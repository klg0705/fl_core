package fl.core.fight;

import fl.core.domain.Fighter;

public class Game {
    public void fight(Fighter a, Fighter b) {
        while (true) {
            if (!isGameover(a, b)) {
                doOneAttack(a, b);
            } else {
                break;
            }
            if (!isGameover(a, b)) {
                doOneAttack(b, a);
            } else {
                break;
            }
        }
    }

    private void doOneAttack(Fighter a, Fighter b) {
        b.setHp(b.getHp() - calcDamage(a, b));
    }

    private int calcDamage(Fighter a, Fighter b) {
        if (a.getAttack() > b.getDefence()) {
            return a.getAttack() - b.getDefence();
        } else {
            return 1;
        }
    }

    private boolean isGameover(Fighter a, Fighter b) {
        return a.getHp() <= 0 || b.getHp() <= 0;
    }
}
