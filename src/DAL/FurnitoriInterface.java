/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Furnitori;
import java.util.List;

/**
 *
 * @author ArtonRamadanis
 */
public interface FurnitoriInterface {
    void create(Furnitori f) throws CourtException;

    void edit(Furnitori f) throws CourtException;

    void delete(Furnitori f) throws CourtException;

    List<Furnitori> findAll() throws CourtException;

    Furnitori findByID(Integer ID) throws CourtException;
}
