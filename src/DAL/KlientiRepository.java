/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Klienti;
import java.util.List;

/**
 *
 * @author RinorJahaj
 */
public class KlientiRepository extends EntMngClass implements KlientiInterface{
    public void create(Klienti k) throws CourtException {
        try {

            em.getTransaction().begin();
            em.persist(k);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Klienti k) throws CourtException {
        try {
            em.getTransaction().begin();
            em.merge(k);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Klienti k) throws CourtException {
        try {
            em.getTransaction().begin();
            em.remove(k);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Klienti> findAll() throws CourtException {
        try {
            return em.createNamedQuery("Klienti.findAll").getResultList();
        } catch (Exception e) {
            throw new CourtException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Klienti findByID(Integer ID) throws CourtException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
