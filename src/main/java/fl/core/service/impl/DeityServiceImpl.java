package fl.core.service.impl;

import java.io.Serializable;

import fl.base.dao.BaseDAO;
import fl.base.service.impl.BaseServiceImpl;
import fl.core.dao.DeityDAO;
import fl.core.domain.Deity;
import fl.core.service.DeityService;

public class DeityServiceImpl extends BaseServiceImpl<Deity> implements DeityService {

    private DeityDAO deityDAO;

    public DeityDAO getDeityDAO() {
        return deityDAO;
    }

    public void setDeityDAO(DeityDAO deityDAO) {
        this.deityDAO = deityDAO;
    }

    @Override
    public Deity getWithFighters(Serializable id) {
        return deityDAO.getWithFighters(id);
    }

    @Override
    public BaseDAO<Deity> getBaseDAO() {
        return deityDAO;
    }

}
