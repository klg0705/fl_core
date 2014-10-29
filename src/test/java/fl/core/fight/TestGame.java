package fl.core.fight;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fl.core.domain.Fighter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class TestGame {

    @Resource
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    @Test
    public final void testFight() {
        Fighter a = new Fighter();
        a.setAttack(10);
        a.setDefence(10);
        a.setHp(50);
        Fighter b = new Fighter();
        b.setAttack(16);
        b.setDefence(20);
        b.setHp(40);

        game.fight(a, b);

        assertEquals(-4, a.getHp());
        assertEquals(31, b.getHp());
    }

}
