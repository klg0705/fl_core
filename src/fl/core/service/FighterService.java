package fl.core.service;

import java.sql.SQLException;
import java.util.List;

import fl.core.domain.Fighter;

public interface FighterService {

    List<Fighter> listAllFighters() throws SQLException;
    
    Fighter addFighter(Fighter fighter) throws SQLException;
}
