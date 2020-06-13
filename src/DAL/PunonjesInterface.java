/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Punonjes;
import java.util.List;

/**
 *
 * @author RinorJahaj
 */
public interface PunonjesInterface {
    void create(Punonjes p) throws CourtException;

    void edit(Punonjes p) throws CourtException;

    void delete(Punonjes p) throws CourtException;

    List<Punonjes> findAll() throws CourtException;

    Punonjes findByID(Integer ID) throws CourtException;
    
}
