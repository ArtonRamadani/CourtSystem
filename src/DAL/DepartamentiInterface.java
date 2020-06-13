/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Departamenti;
import java.util.List;

/**
 *
 * @author RinorJahaj
 */
public interface DepartamentiInterface {
    
    void create(Departamenti d) throws CourtException;

    void edit(Departamenti d) throws CourtException;

    void delete(Departamenti d) throws CourtException;

    List<Departamenti> findAll() throws CourtException;

    Departamenti findByID(Integer ID) throws CourtException;
}
