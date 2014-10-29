package fl.core.util;

import fl.core.domain.Fighter;
import fl.core.util.RandomUtil;

public class PropGenerator {

    public static RandomUtil rand = new RandomUtil();

    public static void generateFighterProp(Fighter fighter) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.getNext();
        }

        int temp = 0;
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 1; i < numbers.length - j; i++) {
                if (numbers[i - 1] < numbers[i]) {
                    temp = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }

        int max = numbers[0] / 10;
        int secondMax = numbers[1] / 10;
        if (numbers[2] % 2 == 0) {
            fighter.setAttack(max + 50);
            fighter.setDefence(secondMax + 20);
        } else {
            fighter.setAttack(secondMax + 50);
            fighter.setDefence(max + 20);
        }

        int life = 800;
        for (int i = numbers.length - 1; i > numbers.length - 4; i--) {
            life += numbers[i];
        }
        life /= 8;
        
        fighter.setHp(life);
        fighter.setMaxHp(life);
    }

}
