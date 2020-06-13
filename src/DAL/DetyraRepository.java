/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Detyra;
import java.util.List;

/**
 *
 * @author ArtonRamadani
 */
public class DetyraRepository extends EntMngClass implements DetyraInterface{
     public void create(Detyra d) throws CourtException {
        try {

            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Detyra d) throws CourtException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Detyra d) throws CourtException {
        try {
            em.getTransaction().begin();
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Detyra> findAll() throws CourtException {
        try {
            return em.createNamedQuery("Detyra.findAll").getResultList();
        } catch (Exception e) {
            throw new CourtException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Detyra findByID(Integer ID) throws CourtException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
