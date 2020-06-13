/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LlojiPageses;
import java.util.List;

/**
 *
 * @author ArtonRamadani
 */
public class LlojiPagesesRepository extends EntMngClass implements LlojiPagesesInterface{
    public void create(LlojiPageses lp) throws CourtException {
        try {

            em.getTransaction().begin();
            em.persist(lp);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(LlojiPageses lp) throws CourtException {
        try {
            em.getTransaction().begin();
            em.merge(lp);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(LlojiPageses lp) throws CourtException {
        try {
            em.getTransaction().begin();
            em.remove(lp);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<LlojiPageses> findAll() throws CourtException {
        try {
            return em.createNamedQuery("LlojiPageses.findAll").getResultList();
        } catch (Exception e) {
            throw new CourtException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public LlojiPageses findByID(Integer ID) throws CourtException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
