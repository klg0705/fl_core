package fl.core.dao.impl;

import fl.core.dao.FighterDAO;
import fl.core.domain.Fighter;
import fl.core.fundamental.BaseDAOImpl;

public class FighterDAOImpl extends BaseDAOImpl<Fighter> implements FighterDAO {

    @Override
    public Class<Fighter> getDomainClass() {
        return Fighter.class;
    }

}
