package fl.core.service.impl;

import java.sql.SQLException;
import java.util.List;

import fl.core.algorithm.generator.PropGenerator;
import fl.core.dao.FighterDAO;
import fl.core.dao.impl.FighterDAOImpl;
import fl.core.domain.Fighter;
import fl.core.service.FighterService;

public class FighterServiceImpl implements FighterService {

    private FighterDAO fighterDAO;

    public FighterServiceImpl() {
        fighterDAO = new FighterDAOImpl();
    }

    @Override
    public List<Fighter> listAllFighters() throws SQLException {
        return fighterDAO.getAll();
    }

    @Override
    public Fighter addFighter(Fighter fighter) throws SQLException {
        PropGenerator.generateFighterProp(fighter);
        fighterDAO.save(fighter);
        return fighter;
    }

}
