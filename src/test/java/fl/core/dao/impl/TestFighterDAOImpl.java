package fl.core.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fl.core.dao.DeityDAO;
import fl.core.dao.FighterDAO;
import fl.core.domain.Deity;
import fl.core.domain.Fighter;

public class TestFighterDAOImpl {

    private Deity deity = new Deity();

    @Before
    public void setUp() throws Exception {
        DeityDAO deityDAO = new DeityDAOImpl();
        deity.setName("GOD");
        deityDAO.save(deity);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCRUD() {
        FighterDAO fighterDAO = new FighterDAOImpl();

        fighterDAO.deleteAll();
        assertEquals(0, fighterDAO.count());

        Fighter fighter = new Fighter();
        fighter.setHp(100);
        fighter.setMaxHp(100);
        fighter.setAttack(10);
        fighter.setDefence(10);
        fighter.setName("Gordon Kong");
        fighter.setNickName("Tank");
        fighter.setImage("images/bear.png");
        fighter.setDeity(deity);

        fighterDAO.save(fighter);

        assertEquals(1, fighterDAO.count());

        Fighter fighter2 = new Fighter();
        fighter2.setName("John Green");
        fighter2.setDeity(deity);
        fighterDAO.save(fighter2);

        assertEquals(2, fighterDAO.count());

        Fighter f = fighterDAO.get(fighter.getId());
        assertEquals("Gordon Kong", f.getName());
        assertEquals("Tank", f.getNickName());

        List<Fighter> list = fighterDAO.getAll();
        assertEquals(2, list.size());

        f.setNickName("Healer");
        fighterDAO.update(f);
        assertEquals("Gordon Kong", f.getName());
        assertEquals("Healer", f.getNickName());

        fighterDAO.delete(f);
        assertEquals(1, fighterDAO.count());

        fighterDAO.deleteById(fighter2.getId());
        assertEquals(0, fighterDAO.count());

    }

}
