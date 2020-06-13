/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Punonjes;
import java.util.List;

/**
 *
 * @author ArtonRamadani
 */
public class PunonjesRepository extends EntMngClass implements PunonjesInterface{
public void create(Punonjes p) throws CourtException {
        try {

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Punonjes p) throws CourtException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Punonjes p) throws CourtException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Punonjes> findAll() throws CourtException {
        try {
            return em.createNamedQuery("Punonjes.findAll").getResultList();
        } catch (Exception e) {
            throw new CourtException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Punonjes findByID(Integer ID) throws CourtException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}    

