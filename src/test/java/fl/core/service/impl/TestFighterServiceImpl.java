package fl.core.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fl.core.domain.Deity;
import fl.core.domain.Fighter;
import fl.core.service.DeityService;
import fl.core.service.FighterService;
import fl.user.domain.Person;
import fl.user.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class TestFighterServiceImpl {

    @Resource(name = "deityServiceImpl")
    private DeityService deityService;

    @Resource(name = "fighterServiceImpl")
    private FighterService fighterService;

    @Resource(name = "personServiceImpl")
    private PersonService personService;

    private Deity deity = new Deity();

    private Person person = new Person();

    @Before
    public void setUp() throws Exception {
        person.setAccount("klg");
        person.setName("Gordon");
        personService.create(person);

        deity.setName("GOD");
        deity.setPerson(person);
        deityService.create(deity);
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

        fighterService.create(fighter);

        assertEquals(1, fighterService.count());

        Fighter fighter2 = new Fighter();
        fighter2.setName("John Green");
        fighter2.setDeity(deity);
        fighterService.create(fighter2);

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
