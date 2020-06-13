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
public interface DetyraInterface {
      void create(Detyra d) throws CourtException;

    void edit(Detyra d) throws CourtException;

    void delete(Detyra d) throws CourtException;

    List<Detyra> findAll() throws CourtException;

    Detyra findByID(Integer ID) throws CourtException;
    
}
