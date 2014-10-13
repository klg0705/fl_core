package fl.core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fl.core.algorithm.generator.PropGenerator;
import fl.core.domain.Fighter;

public class FighterServiceImpl implements FighterService {

    private static final String URL = "jdbc:mysql://localhost:3306/fl?useUnicode=true&characterEncoding=UTF-8";
    
    private static final String SELECT_ALL_SQL = "SELECT * FROM FL_FIGHTERS";
    
    private static final String INSERT_SQL = "INSERT INTO FL_FIGHTERS (`NAME`, `NICKNAME`, `HP`, `MAXHP`, `ATTACK`, `DEFENCE`) VALUES (?, ?, ?, ?, ?, ?)";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Fighter> listAllFighters() throws SQLException {
        List<Fighter> result = new ArrayList<Fighter>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConn();
            ps = conn.prepareStatement(SELECT_ALL_SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Fighter fighter = new Fighter();
                fighter.setId(rs.getInt("ID"));
                fighter.setName(rs.getString("NAME"));
                fighter.setNickName(rs.getString("NICKNAME"));
                fighter.setHp(rs.getInt("HP"));
                fighter.setMaxHp(rs.getInt("MAXHP"));
                fighter.setAttack(rs.getInt("ATTACK"));
                fighter.setDefence(rs.getInt("DEFENCE"));
                fighter.setImage(rs.getString("IMAGE"));

                result.add(fighter);
            }
        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return result;
    }

    @Override
    public Fighter addFighter(Fighter fighter) throws SQLException {
        
        PropGenerator.generateFighterProp(fighter);
        
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConn();
            ps = conn.prepareStatement(INSERT_SQL);
            ps.setString(1, fighter.getName());
            ps.setString(2, fighter.getNickName());
            ps.setInt(3, fighter.getHp());
            ps.setInt(4, fighter.getMaxHp());
            ps.setInt(5, fighter.getAttack());
            ps.setInt(6, fighter.getDefence());
            ps.executeUpdate();
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return fighter;
    }

    private Connection getConn() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, "root", "");
        return conn;
    }

    public static void main(String[] a) {
        Fighter test = new Fighter();
        test.setName("孔令国");
        test.setNickName("蝈蝈");
        test.setHp(1);
        test.setMaxHp(1);
        test.setAttack(1);
        test.setDefence(1);
        
        FighterServiceImpl inst = new FighterServiceImpl();
        try {
            inst.addFighter(test);
            
            List<Fighter> list = inst.listAllFighters();
            for (Fighter fighter : list) {
                System.out.println(fighter.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
