/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Perdoruesi;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author RinorJahaj
 */
public class PerdoruesiRepository extends EntMngClass implements PerdoruesiInterface{
    
    @Override
    public void create(Perdoruesi p) throws CourtException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Perdoruesi p) throws CourtException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CourtException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Perdoruesi p) throws CourtException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (e.getMessage().contains("Error Code: 547")) {
                throw new CourtException("Msg \n" + "E dhena eshte perdorur dhe nuk mund te fshihet!");
            } else {
                throw new CourtException("Msg \n" + e.getMessage());
            }
        }
    }

    @Override
    public List<Perdoruesi> findAll() throws CourtException {
        try {
            return em.createNamedQuery("Perdoruesi.findAll").getResultList();
        } catch (Exception e) {
            throw new CourtException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Perdoruesi findByID(Integer ID) throws CourtException {
        try {
            Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (Perdoruesi) query.getSingleResult();
        } catch (Exception e) {
            throw new CourtException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Perdoruesi loginByUsernameAndPassword(String u, String p) throws CourtException {
        try {
            Query query
                    = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.username = :us AND p.password= :psw");
            query.setParameter("us", u);
            query.setParameter("psw", p);
            return (Perdoruesi) query.getSingleResult();
        } catch (Exception e) {
            throw new CourtException("Msg! \n" + e.getMessage());
        }
    }

}
