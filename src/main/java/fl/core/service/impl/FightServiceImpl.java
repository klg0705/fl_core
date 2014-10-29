package fl.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import fl.core.domain.Fighter;
import fl.core.fight.Game;
import fl.core.service.FightService;
import fl.core.service.FighterService;

public class FightServiceImpl implements FightService {

    private FighterService fighterService;

    private Game game;

    public void setFighterService(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Fighter> fight(String[] fighterIds) {
        Fighter fighter1 = fighterService.get(Integer.parseInt(fighterIds[0]));
        Fighter fighter2 = fighterService.get(Integer.parseInt(fighterIds[1]));

        List<Fighter> fighters = new ArrayList<Fighter>();
        fighters.add(fighter1);
        fighters.add(fighter2);

        return fight(fighters);
    }

    public List<Fighter> fight(List<Fighter> fighters) {
        game.fight(fighters.get(0), fighters.get(1));
        return fighters;
    }
}
