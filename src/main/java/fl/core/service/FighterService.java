package fl.core.service;

import org.springframework.transaction.annotation.Transactional;

import fl.core.domain.Fighter;
import fl.core.fundamental.BaseService;

@Transactional
public interface FighterService extends BaseService<Fighter> {

}
