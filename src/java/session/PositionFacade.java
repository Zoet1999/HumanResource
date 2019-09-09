/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Experience;
import entity.Position;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Zoet
 */
@Stateless
public class PositionFacade extends AbstractFacade<Position> {

    @PersistenceContext(unitName = "HumanResourcePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PositionFacade() {
        super(Position.class);
    }

    public List<String> findDeparments(int companyid) {
      //出现重复
        String s = "SELECT * FROM position";
            s = s + " WHERE position.Company_companyNo=" + String.valueOf(companyid);
        Query query = em.createNativeQuery(s, Position.class);
        List<String> ss = new ArrayList<String>();
        List<Position> ps = query.getResultList();
        for (Position p : ps) {
            if(!ss.contains(p.getDepartment()))
            ss.add(p.getDepartment());
        }
        return ss;
    }

    public List<Position> findPositions(int companyid,String depart) {
        String s = "SELECT * FROM position";
        s = s + " WHERE position.Company_companyNo=" + String.valueOf(companyid);
        if (depart != null) {
            s = s + " AND position.department='" + depart + "'";
        }
        Query query = em.createNativeQuery(s, Position.class);
//        List<String> ss = new ArrayList<String>();
        List<Position> ps = query.getResultList();
//        for (Position p : ps) {
//            ss.add(p.getPosition());
//        }
        return ps;
    }
//    public List<String> findPositions() {
//        String s = "SELECT * FROM position";
//        Query query = em.createNativeQuery(s, Position.class);
//        List<String> ss=new ArrayList<String>();
//        List<Position> ps = query.getResultList();
//        for(Position p:ps){
//        ss.add("."+p.getPosition());
//        }
//        return ss;
//    } 

//    public List<Experience> findExperience() {
//          HttpServletRequest request1 = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        String companyid = request1.getParameter("companyid");
//         HttpServletRequest request2 = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        String departmentid = request2.getParameter("departmentid");
//        String s = "SELECT staff FROM staff experience"
//                + "";
//          if(companyid!=null){
//               s=s+" WHERE position.Company_companyNo="+companyid;
//        }        
//            if(departmentid!=null){
//               s=s+" AND position.department='"+departmentid+"'";
//        } 
//        Query query = em.createNativeQuery(s, Experience.class);
//        List<Experience> ex = query.getResultList();
//        return ex;
//    }
}
