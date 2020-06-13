/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Prioriteti;
import java.util.List;

/**
 *
 * @author ArtonRamadani
 */
public interface PrioritetiInterface {
      void create(Prioriteti p) throws CourtException;

    void edit(Prioriteti p) throws CourtException;

    void delete(Prioriteti p) throws CourtException;

    List<Prioriteti> findAll() throws CourtException;

    Prioriteti findByID(Integer ID) throws CourtException;
}
