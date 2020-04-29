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
 * @author RinorJahaj
 */
public interface LendaInterface {
      void create(Lenda l) throws CourtException;

    void edit(Lenda l) throws CourtException;

    void delete(Lenda l) throws CourtException;

    List<Lenda> findAll() throws CourtException;

    Lenda findByID(Integer ID) throws CourtException;
}
