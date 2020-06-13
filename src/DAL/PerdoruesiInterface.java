/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Perdoruesi;
import java.util.List;

/**
 *
 * @author RinorJahaj
 */
public interface PerdoruesiInterface {
     void create(Perdoruesi p) throws CourtException;

    void edit(Perdoruesi p) throws CourtException;

    void delete(Perdoruesi p) throws CourtException;

    List<Perdoruesi> findAll() throws CourtException;

    Perdoruesi findByID(Integer ID) throws CourtException;

    Perdoruesi loginByUsernameAndPassword(String u, String p) throws CourtException;
}
