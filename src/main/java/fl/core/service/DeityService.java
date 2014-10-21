package fl.core.service;

import java.io.Serializable;

import fl.core.domain.Deity;
import fl.core.fundamental.BaseService;

public interface DeityService extends BaseService<Deity> {

    Deity getWithFighters(Serializable id);

}
