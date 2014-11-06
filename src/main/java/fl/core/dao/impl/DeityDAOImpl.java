package fl.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import fl.base.dao.impl.BaseDAOImpl;
import fl.core.dao.DeityDAO;
import fl.core.domain.Deity;

public class DeityDAOImpl extends BaseDAOImpl<Deity> implements DeityDAO {

    public static final String QUERY_DEITY_BY_PERSON = "select d from Deity d where d.person.id = :personId";

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

    @SuppressWarnings("unchecked")
    @Override
    public Deity findByPersonId(Serializable personId) {
        List<Deity> list = sessionFactory.getCurrentSession().createQuery(QUERY_DEITY_BY_PERSON)
                .setParameter("personId", personId).list();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
