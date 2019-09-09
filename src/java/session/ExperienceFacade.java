/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Experience;
import entity.Staff;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zoet
 */
@Stateless
public class ExperienceFacade extends AbstractFacade<Experience> {

    @PersistenceContext(unitName = "HumanResourcePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExperienceFacade() {
        super(Experience.class);
    }

    public List<Staff> findStaffs(List<Experience> ex) {

        List<Staff> staffs = new ArrayList<Staff>();
        for (Experience e : ex) {
            Staff s = e.getStaffstaffNo();
            staffs.add(s);
        }
        return staffs;
    }

}
