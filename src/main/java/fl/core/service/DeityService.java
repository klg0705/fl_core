package fl.core.service;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import fl.core.domain.Deity;
import fl.core.fundamental.BaseService;

@Transactional
public interface DeityService extends BaseService<Deity> {

    Deity getWithFighters(Serializable id);

}
