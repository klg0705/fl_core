package fl.core.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fl.core.domain.Fighter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class TestFightServiceImpl {

    @Resource
    FightServiceImpl service;
    
    @Test
    public final void test() {
        List<Fighter> list = new ArrayList<Fighter>();
        Fighter a = new Fighter();
        a.setAttack(10);
        a.setDefence(10);
        a.setHp(50);
        list.add(a);
        Fighter b = new Fighter();
        b.setAttack(16);
        b.setDefence(20);
        b.setHp(40);
        list.add(b);

        list = service.fight(list);
        assertEquals(-4, list.get(0).getHp());
        assertEquals(31, list.get(1).getHp());
    }

}
