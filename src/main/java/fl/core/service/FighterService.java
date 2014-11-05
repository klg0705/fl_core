package fl.core.service;

import org.springframework.transaction.annotation.Transactional;

import fl.base.service.BaseService;
import fl.core.domain.Fighter;

@Transactional
public interface FighterService extends BaseService<Fighter> {

}
