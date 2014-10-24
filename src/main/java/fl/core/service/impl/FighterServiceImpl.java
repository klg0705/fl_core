package fl.core.service.impl;

import fl.core.algorithm.generator.PropGenerator;
import fl.core.dao.FighterDAO;
import fl.core.domain.Fighter;
import fl.core.fundamental.BaseDAO;
import fl.core.fundamental.BaseServiceImpl;
import fl.core.service.FighterService;

public class FighterServiceImpl extends BaseServiceImpl<Fighter> implements FighterService {

    private FighterDAO fighterDAO;

    public FighterServiceImpl() {
    }

    public FighterServiceImpl(FighterDAO fighterDAO) {
        this.fighterDAO = fighterDAO;
    }

    public FighterDAO getFighterDAO() {
        return fighterDAO;
    }

    public void setFighterDAO(FighterDAO fighterDAO) {
        this.fighterDAO = fighterDAO;
    }

    @Override
    public void add(Fighter fighter) {
        PropGenerator.generateFighterProp(fighter);
        super.add(fighter);
    }

    @Override
    public BaseDAO<Fighter> getBaseDAO() {
        return fighterDAO;
    }

}
