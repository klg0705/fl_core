package fl.core.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fl.core.domain.Deity;
import fl.core.domain.Fighter;
import fl.core.service.DeityService;
import fl.core.service.FighterService;

public class TestFighterServiceImplWithoutRunWith {

    private DeityService deityService;

    private FighterService fighterService;

    private Deity deity = new Deity();

    @SuppressWarnings("resource")
    public TestFighterServiceImplWithoutRunWith() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-test.xml");
        deityService = (DeityService) ac.getBean("deityServiceImpl");
        fighterService = (FighterService) ac.getBean("fighterServiceImpl");
    }

    @Before
    public void setUp() throws Exception {
        deity.setName("GOD");
        deityService.add(deity);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCRUD() {

        fighterService.deleteAll();
        assertEquals(0, fighterService.count());

        Fighter fighter = new Fighter();
        fighter.setHp(100);
        fighter.setMaxHp(100);
        fighter.setAttack(10);
        fighter.setDefence(10);
        fighter.setName("Gordon Kong");
        fighter.setNickName("Tank");
        fighter.setImage("images/bear.png");
        fighter.setDeity(deity);

        fighterService.add(fighter);

        assertEquals(1, fighterService.count());

        Fighter fighter2 = new Fighter();
        fighter2.setName("John Green");
        fighter2.setDeity(deity);
        fighterService.add(fighter2);

        assertEquals(2, fighterService.count());

        Fighter f = fighterService.get(fighter.getId());
        assertEquals("Gordon Kong", f.getName());
        assertEquals("Tank", f.getNickName());

        List<Fighter> list = fighterService.getAll();
        assertEquals(2, list.size());

        f.setNickName("Healer");
        fighterService.update(f);
        assertEquals("Gordon Kong", f.getName());
        assertEquals("Healer", f.getNickName());

        fighterService.delete(f);
        assertEquals(1, fighterService.count());

        fighterService.deleteById(fighter2.getId());
        assertEquals(0, fighterService.count());

    }

}
