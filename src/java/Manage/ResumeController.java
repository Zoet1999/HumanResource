/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

/**
 *
 * @author Xuuuan
 */
import entity.Staff;
import Manage.util.JsfUtil;
import Manage.util.PaginationHelper;


import entity.Company;
import entity.Experience;
import entity.Position;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import javax.faces.model.DataModel;

import session.CompanyFacade;
import session.ExperienceFacade;
import session.PositionFacade;
import session.StaffFacade;

@Named("resumeController")
@SessionScoped
public class ResumeController implements Serializable {

    private Staff staff;
    private Company company1;
    private Position position1;

    private Company company2;
    private Position position2;

    private Company company3;
    private Position position3;

    private Company company4;
    private Position position4;

    private Company company5;
    private Position position5;

    private Experience experience1;
    private Experience experience2;
    private Experience experience3;
    private Experience experience4;
    private Experience experience5;
    private DataModel items = null;

    @EJB
    private session.StaffFacade staffFacade;
    @EJB
    private session.CompanyFacade companyFacade;
    @EJB
    private session.ExperienceFacade experienceFacade;
    @EJB
    private session.PositionFacade positionFacade;

    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ResumeController() {
    }

    public Staff getSselected() {
        if (staff == null) {
            staff = new Staff();
            selectedItemIndex = -1;
        }
        return staff;
    }

//    公司经历1--------------------------------------------------------------
    public Company getC1selected() {
        if (company1 == null) {
            company1 = new Company();
            company1.setCompanyName("UnKnown");
            selectedItemIndex = -1;
        }
        return company1;
    }

    public Position getP1selected() {
        if (position1 == null) {
            position1 = new Position();
            position1.setPosition("UnKnown");
            position1.setDepartment("UnKnown");
            selectedItemIndex = -1;
        }
        return position1;
    }

    public Experience getE1selected() {
        if (experience1 == null) {
            experience1 = new Experience();
           Date date1 = new Date(); 
            experience1.setIniDate(date1);
            experience1.setDepDate(date1);
            selectedItemIndex = -1;
        }
        return experience1;
    }

    //    公司经历2------------------------------------------------------
    public Company getC2selected() {
        if (company2 == null) {
            company2 = new Company();
            company2.setCompanyName("UnKnown");
            selectedItemIndex = -1;
        }
        return company2;
    }

    public Position getP2selected() {
        if (position2 == null) {
            position2 = new Position();
            position2.setPosition("UnKnown");
            position2.setDepartment("UnKnown");
            selectedItemIndex = -1;
        }
        return position2;
    }

    public Experience getE2selected() {
        if (experience2 == null) {
            experience2 = new Experience();
            selectedItemIndex = -1;
            Date date2 = new Date(); 
            experience2.setIniDate(date2);
            experience2.setDepDate(date2);
        }
        return experience2;
    }

    //    公司经历3--------------------------------------------------
    public Company getC3selected() {
        if (company3 == null) {
            company3 = new Company();
            company3.setCompanyName("UnKnown");
            selectedItemIndex = -1;
        }
        return company3;
    }

    public Position getP3selected() {
        if (position3 == null) {
            position3 = new Position();
            position3.setPosition("UnKnown");
            position3.setDepartment("UnKnown");
            selectedItemIndex = -1;
        }
        return position3;
    }

    public Experience getE3selected() {
        if (experience3 == null) {
            experience3 = new Experience();
            Date date3 = new Date(); 
            experience3.setIniDate(date3);
            experience3.setDepDate(date3);
            selectedItemIndex = -1;
        }
        return experience3;
    }

    //    公司经历4---------------------------------------------
    public Company getC4selected() {
        if (company4 == null) {
            company4 = new Company();
            company4.setCompanyName("UnKnown");
            selectedItemIndex = -1;
        }
        return company4;
    }

    public Position getP4selected() {
        if (position4 == null) {
            position4 = new Position();
            position4.setPosition("UnKnown");
            position4.setDepartment("UnKnown");
            selectedItemIndex = -1;
        }
        return position4;
    }

    public Experience getE4selected() {
        if (experience4 == null) {
            experience4 = new Experience();
            Date date4 = new Date(); 
            experience4.setIniDate(date4);
            experience4.setDepDate(date4);
            selectedItemIndex = -1;
        }
        return experience4;
    }

    //    公司经历5---------------------------------------------
    public Company getC5selected() {
        if (company5 == null) {
            company5 = new Company();
            company5.setCompanyName("UnKnown");
            selectedItemIndex = -1;
        }
        return company5;
    }

    public Position getP5selected() {
        if (position5 == null) {
            position5 = new Position();
            position5.setPosition("UnKnown");
            position5.setDepartment("UnKnown");
            selectedItemIndex = -1;
        }
        return position5;
    }

    public Experience getE5selected() {
        if (experience5 == null) {
            experience5 = new Experience();
            Date date5 = new Date(); 
            experience5.setIniDate(date5);
            experience5.setDepDate(date5);
            selectedItemIndex = -1;
        }
        return experience5;
    }

//   ---------------------------------------------------------------------------------------------------------
    private StaffFacade getStaffFacade() {
        return staffFacade;
    }

    private CompanyFacade getCompanyFacade() {
        return companyFacade;
    }

    private ExperienceFacade getExperienceFacade() {
        return experienceFacade;
    }

    private PositionFacade getPositionFacade() {
        return positionFacade;
    }
    public String prepareCreate(){
        
        return "Create";
    }

    public String create() {
        try {

            getStaffFacade().create(staff);

            if((company1.getCompanyName().equals("UnKnown"))==false){
                if(company1.getCompanyName().length()!=0){
            getCompanyFacade().create(company1);
            position1.setCompanycompanyNo(company1);
            getPositionFacade().create(position1);
            experience1.setStaffstaffNo(staff);
            experience1.setPositionpositionNo(position1);
            getExperienceFacade().create(experience1);
                }
            }
            
            if((company2.getCompanyName().equals("UnKnown"))==false){
                if(company2.getCompanyName().length()!=0){
            getCompanyFacade().create(company2);
            position2.setCompanycompanyNo(company2);
            getPositionFacade().create(position2);
            experience2.setStaffstaffNo(staff);
            experience2.setPositionpositionNo(position2);
            getExperienceFacade().create(experience2);
                }
            }
            
            if((company3.getCompanyName().equals("UnKnown"))==false){
                if(company3.getCompanyName().length()!=0){
            getCompanyFacade().create(company3);
            position3.setCompanycompanyNo(company3);
            getPositionFacade().create(position3);
            experience3.setStaffstaffNo(staff);
            experience3.setPositionpositionNo(position3);
            getExperienceFacade().create(experience3);
                }
            }
            
            if((company4.getCompanyName().equals("UnKnown"))==false){
                if(company4.getCompanyName().length()!=0){
            getCompanyFacade().create(company4);
            position4.setCompanycompanyNo(company4);
            getPositionFacade().create(position4);
            experience4.setStaffstaffNo(staff);
            experience4.setPositionpositionNo(position4);
            getExperienceFacade().create(experience4);
                }
            }
            
            if((company5.getCompanyName().equals("UnKnown"))==false){
                if(company5.getCompanyName().length()!=0){
            getCompanyFacade().create(company5);
            position5.setCompanycompanyNo(company5);
            getPositionFacade().create(position5);
            experience5.setStaffstaffNo(staff);
            experience5.setPositionpositionNo(position5);
            getExperienceFacade().create(experience5);
                }
            }
            
            
          
            
            
            
            
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StaffCreated"));
            
            
            return "resumeSet";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    
   

}
