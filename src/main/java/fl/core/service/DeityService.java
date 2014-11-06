package fl.core.service;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import fl.base.service.BaseService;
import fl.core.domain.Deity;

@Transactional
public interface DeityService extends BaseService<Deity> {

    Deity getWithFighters(Serializable id);

    Deity findByPersonId(Serializable personId);

}
