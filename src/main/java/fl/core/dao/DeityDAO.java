package fl.core.dao;

import java.io.Serializable;

import fl.base.dao.BaseDAO;
import fl.core.domain.Deity;

public interface DeityDAO extends BaseDAO<Deity> {

    Deity getWithFighters(Serializable id);
}
