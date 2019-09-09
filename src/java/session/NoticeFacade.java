/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Notice;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zoet
 */
@Stateless
public class NoticeFacade extends AbstractFacade<Notice> {

    @PersistenceContext(unitName = "HumanResourcePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoticeFacade() {
        super(Notice.class);
    }
    
        public List<Notice> findNotices() {
        String s="select * from human_resources.notice order by createDate desc;";
        return getEntityManager().createNativeQuery(s,Notice.class).getResultList();
    }
}
