package fl.core.service;

import java.util.List;

import fl.core.domain.Fighter;

public interface FightService {

    List<Fighter> fight(List<Fighter> fighters);

    List<Fighter> fight(String[] fighterIds);
}
