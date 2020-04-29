/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LlojiPageses;
import java.util.List;

/**
 *
 * @author RinorJahaj
 */
public interface LlojiPagesesInterface {

    void create(LlojiPageses lp) throws CourtException;

    void edit(LlojiPageses lp) throws CourtException;

    void delete(LlojiPageses lp) throws CourtException;

    List<LlojiPageses> findAll() throws CourtException;

    LlojiPageses findByID(Integer ID) throws CourtException;
}
