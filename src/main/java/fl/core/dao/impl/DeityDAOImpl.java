package fl.core.dao.impl;

import java.io.Serializable;

import fl.core.dao.DeityDAO;
import fl.core.domain.Deity;
import fl.core.fundamental.BaseDAOImpl;

public class DeityDAOImpl extends BaseDAOImpl<Deity> implements DeityDAO {

    @Override
    public Class<Deity> getDomainClass() {
        return Deity.class;
    }

    @Override
    public Deity getWithFighters(Serializable id) {
        Deity deity = get(id);
        deity.getFighters().size();
        return deity;
    }
}
