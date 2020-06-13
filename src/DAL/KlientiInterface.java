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
 * @author ArtonRamadani
 */
public interface KlientiInterface {

    void create(Klienti k) throws CourtException;

    void edit(Klienti k) throws CourtException;

    void delete(Klienti k) throws CourtException;

    List<Klienti> findAll() throws CourtException;

    Klienti findByID(Integer ID) throws CourtException;
}
