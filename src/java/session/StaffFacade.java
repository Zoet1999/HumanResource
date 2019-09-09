/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Experience;
import entity.Position;
import entity.Staff;
import entity.StaffPosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class StaffFacade extends AbstractFacade<Staff> {

    @PersistenceContext(unitName = "HumanResourcePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StaffFacade() {
        super(Staff.class);
    }

    public List<String> getStaffPos() {
        String s = "SELECT * FROM position";
        Query query = em.createNativeQuery(s, String.class);
        List<String> ss = new ArrayList<String>();
        List<Position> ps = query.getResultList();
        for (Position p : ps) {
            ss.add("." + p.getPosition());
        }
        return ss;
    }

    public List<StaffPosition> findStaffs(int companyid, String departmentid) {//职位变一样
        String s = "SELECT distinct s.staffNo,s.name,s.sex,s.age,s.address,s.tel,s.workingYears FROM staff s,experience e,position p";

        s = s + " WHERE s.staffNo=e.Staff_staffNo AND e.Position_positionNo=p.positionNo AND p.Company_companyNo=" + String.valueOf(companyid);
        if (departmentid != null) {
            s = s + " AND p.department='" + departmentid + "'";
        }
        Query query = em.createNativeQuery(s, Staff.class);
        List<Staff> ex = query.getResultList();
        List<Experience> exp;
        List<StaffPosition> result = new ArrayList<StaffPosition>();
        for (Staff e : ex) {
            s = "SELECT distinct e.expNo,e.Staff_staffNo,e.Position_positionNo,e.IniDate,e.DepDate FROM experience e,position p WHERE e.Position_positionNo=p.positionNo"
                    + " AND p.Company_companyNo="+companyid+" AND p.department='"+departmentid+"' AND e.Staff_staffNo=" + String.valueOf(e.getStaffNo());
            Query query2 = em.createNativeQuery(s, Experience.class);
            exp = query2.getResultList();
            result.add(new StaffPosition(e, exp));
        }
        return result;
    }

    public List<Experience> getResumes(int index) {
//         String s = "SELECT e.IniDate,e.DepDate,c.companyName,c.address,p.position,p.department,p.level  FROM experience e,company c,position p WHERE";
//         s=s+" e.Position_positionNo=p.positionNo AND p.Company_companyNo=c.companyNo AND e.Staff_staffNo="+index;
//         Query query = em.createNativeQuery(s, Resume.class);
        String s = "SELECT e.expNo,e.Staff_staffNo,e.Position_positionNo,e.IniDate,e.DepDate  FROM experience e,company c,position p WHERE";
        s = s + " e.Position_positionNo=p.positionNo AND p.Company_companyNo=c.companyNo AND e.Staff_staffNo=" + index;
        Query query = em.createNativeQuery(s, Experience.class);

        List<Experience> rs = query.getResultList();
        return rs;
    }

    public List<Staff> SearchStaff(String key, String company, String department, String position, String time, String address) {
        String s = "SELECT distinct staff.staffNo,staff.name,staff.sex,staff.age,staff.address,staff.tel,staff.mail,staff.workingYears FROM staff,experience,company,position WHERE staff.staffNo=experience.Staff_staffNo AND experience.Position_positionNo=position.positionNo AND position.Company_companyNo=company.companyNo";
        if (key != null) {
            if (key.length() != 0) {
                s = s + " AND staff.name='" + key + "'";
            }
        }
        if (company != null) {
            if (company.length() != 0) {
                s = s + " AND company.companyName = '" + company + "'";
            }
        }
        if (department != null) {
            if (department.length() != 0) {
                s = s + " AND position.department = '" + department + "'";
            }
        }
        if (position != null) {
            if (position.length() != 0) {
                s = s + " AND position.position='" + position + "'";
            }
        }
        if (time != null) {
            if (time.length() != 0) {
                s = s + " AND IniDate > '" + time + "'";
            }
        }
        if (address != null) {
            if (address.length() != 0) {
                s = s + " AND staff.address = '" + address + "'";
            }
        }

        Query query = em.createNativeQuery(s, Staff.class);

        if (key != null) {
            if (key.length() != 0) {
                query.setParameter("mkey", key);
            }
        }

        return query.getResultList();
    }
}
