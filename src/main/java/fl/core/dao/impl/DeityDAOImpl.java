package fl.core.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;

import fl.core.dao.DeityDAO;
import fl.core.domain.Deity;
import fl.core.fundamental.BaseDAOImpl;
import fl.core.fundamental.HibernateUtil;

public class DeityDAOImpl extends BaseDAOImpl<Deity> implements DeityDAO {

    @Override
    public Class<Deity> getDomainClass() {
        return Deity.class;
    }

    @Override
    public Deity getWithFighters(Serializable id) {
        Session session = null;
        Deity deity = null;
        try {
            session = HibernateUtil.getSession();
            deity = (Deity) session.get(getDomainClass(), id);
            deity.getFighters().size();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return deity;
    }

}
