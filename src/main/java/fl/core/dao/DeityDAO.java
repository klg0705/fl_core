package fl.core.dao;

import java.io.Serializable;

import fl.core.domain.Deity;
import fl.core.fundamental.BaseDAO;

public interface DeityDAO extends BaseDAO<Deity> {

    Deity getWithFighters(Serializable id);
}
