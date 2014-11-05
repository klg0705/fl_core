package fl.core.dao.impl;

import fl.base.dao.impl.BaseDAOImpl;
import fl.core.dao.FighterDAO;
import fl.core.domain.Fighter;

public class FighterDAOImpl extends BaseDAOImpl<Fighter> implements FighterDAO {

    @Override
    public Class<Fighter> getDomainClass() {
        return Fighter.class;
    }

}
