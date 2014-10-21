package fl.core.service.impl;

import fl.core.algorithm.generator.PropGenerator;
import fl.core.dao.impl.FighterDAOImpl;
import fl.core.domain.Fighter;
import fl.core.fundamental.BaseServiceImpl;
import fl.core.service.FighterService;

public class FighterServiceImpl extends BaseServiceImpl<Fighter> implements FighterService {

    public FighterServiceImpl() {
        super.setBaseDAO(new FighterDAOImpl());
    }

    @Override
    public void add(Fighter fighter) {
        PropGenerator.generateFighterProp(fighter);
        super.add(fighter);
    }

}
