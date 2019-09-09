package Manage;

import entity.Account;
import Manage.util.JsfUtil;
import Manage.util.PaginationHelper;
import session.AccountFacade;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sun.misc.BASE64Encoder;


@Named("accountController")
@SessionScoped
public class AccountController implements Serializable {

    private Account current;
    private DataModel items = null;
    @EJB
    private session.AccountFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    private List<Account> acc;
    private String passwordConfirm;

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public AccountController() {
        
    }

    public Account getSelected() {
        if (current == null) {
            current = new Account();
            selectedItemIndex = -1;
        }
        return current;
    }

    private AccountFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Account) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Account();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AccountCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Account) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AccountUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Account) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AccountDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public List<Account> getAllAccount() {
        acc = ejbFacade.findAll();
        return acc;
    }

    public Account getAccount(java.lang.Integer id) {

        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Account.class)
    public static class AccountControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AccountController controller = (AccountController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "accountController");
            return controller.getAccount(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Account) {
                Account o = (Account) object;
                return getStringKey(o.getAccountNo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Account.class.getName());
            }
        }

    }

    public String isLogin() {
        boolean isRight = false;
        String newpassword = "";
        getAllAccount();
        HttpSession req = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        req.setAttribute("userName", current.getName());
        
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            newpassword = base64en.encode(md5.digest(current.getPwd().getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Account a : acc) {
            if (a.getPwd().equals(newpassword) && a.getName().equals(current.getName())) {
                isRight = true;
            }
        }
        if (isRight) {
            
            return "homepage.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("用户名与密码不匹配，请重新输入"));
            return "login.xhtml";
        }

    }

    public String isRegister() {
        boolean isRight = false;
        getAllAccount();
        String newpassword = "";
        for (Account a : acc) {
            if (a.getName().equals(current.getName())) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("用户名已被占用，请修改用户名"));
                return "register.xhtml";
            }
        }
        if (current.getPwd().equals(passwordConfirm)) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                BASE64Encoder base64en = new BASE64Encoder();
                //加密后的字符串
                newpassword = base64en.encode(md5.digest(current.getPwd().getBytes("utf-8")));
                current.setPwd(newpassword);
                ejbFacade.create(current);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("成功注册！"));
                isRight = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("输入的两次密码不一致！"));
        }
        if (isRight) {
            return "login.xhtml";
        } else {
            return "register.xhtml";
        }

    }  

    public String isAdmin() {
        String admin = "";
        getAllAccount();
        for (Account a : acc) {
            if (a.getName().equals(current.getName())) {
                admin = a.getAuthority();
            }
        }
        if(admin.equals("admin")){
            return "AdminDbPage/index.xhtml";
        }
        else{
            return "error.xhtml";
        }
        
    }
      public String isAdmin2() {
        String admin = "";
        getAllAccount();
        for (Account a : acc) {
            if (a.getName().equals(current.getName())) {
                admin = a.getAuthority();
            }
        }
        if(admin.equals("admin")){
            return "adindex.xhtml";
        }
        else{
            return "error.xhtml";
        }
        
    }
}
