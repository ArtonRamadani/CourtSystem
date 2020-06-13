/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Avokati;
import java.util.List;

/**
 *
 * @author ArtonRamadani
 */
public interface AvokatiInterface {

    void create(Avokati a) throws CourtException;

    void edit(Avokati a) throws CourtException;

    void delete(Avokati a) throws CourtException;

    List<Avokati> findAll() throws CourtException;

    Avokati findByID(Integer ID) throws CourtException;
}
