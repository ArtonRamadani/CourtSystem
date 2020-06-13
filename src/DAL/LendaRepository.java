/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Lenda;
import java.util.List;

/**
 *
 * @author ArtonRamadani
 */
public class LendaRepository extends EntMngClass implements LendaInterface{
    public void create(Lenda l) throws CourtException  {
        try {

            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Lenda l) throws CourtException {
        try {
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Lenda l) throws CourtException {
        try {
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Lenda> findAll() throws CourtException {
        try {
            return em.createNamedQuery("Lenda.findAll").getResultList();
        } catch (Exception e) {
            throw new CourtException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Lenda findByID(Integer ID) throws CourtException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
