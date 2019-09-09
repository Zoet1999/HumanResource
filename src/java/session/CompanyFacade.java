/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Company;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Zoet
 */
@Stateless
public class CompanyFacade extends AbstractFacade<Company> {

    @PersistenceContext(unitName = "HumanResourcePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompanyFacade() {
        super(Company.class);
    }

    public List<Company> SearchCompany(String key, String department, String position, String city) {
//String s="SELECT distinct company.companyNo,company.companyName,company.address,company.remark FROM company,position WHERE company.companyNo = position.Company_companyNo AND company.address='深圳'";
        String s ="SELECT distinct company.companyNo,company.companyName,company.address,company.remark FROM company,position WHERE company.companyNo = position.Company_companyNo";
        if (city != null) {
            if (city.length() != 0) {
                s = s + " AND company.address='" + city + "'";
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
        if (key != null) {
            if (key.length() != 0) {
                s = s + " AND company.companyName = '" + key + "'";
            }
        }
        Query query = em.createNativeQuery(s, Company.class);

        List<Company> result = query.getResultList();
        return result;
    }

    public int countCompany(String key, String department, String position, String city) {
        String s = "SELECT count(distinct company.companyNo) FROM company,position WHERE company.companyNo = position.Company_companyNo";
        if (city != null) {
            if (city.length() != 0) {
                s = s + " AND company.address='" + city + "'";
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
        if (key != null) {
            if (key.length() != 0) {
                s = s + " AND company.companyName = '" + key + "'";
            }
        }
        Query query = em.createNativeQuery(s);
        return ((Long) query.getSingleResult()).intValue();

    }
}
