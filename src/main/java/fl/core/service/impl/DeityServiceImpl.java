package fl.core.service.impl;

import java.io.Serializable;

import fl.core.dao.DeityDAO;
import fl.core.dao.impl.DeityDAOImpl;
import fl.core.domain.Deity;
import fl.core.fundamental.BaseServiceImpl;
import fl.core.service.DeityService;

public class DeityServiceImpl extends BaseServiceImpl<Deity> implements DeityService {

    DeityDAO deityDAO;
    
    public DeityServiceImpl() {
        deityDAO = new DeityDAOImpl();
        super.setBaseDAO(deityDAO);
    }

    @Override
    public Deity getWithFighters(Serializable id) {
        return deityDAO.getWithFighters(id);
    }

}
