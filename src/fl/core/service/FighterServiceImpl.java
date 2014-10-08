package fl.core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fl.core.domain.Fighter;

public class FighterServiceImpl implements FighterService {

    private static final String URL = "jdbc:mysql://localhost:3306/fl";

    @Override
    public List<Fighter> listAllFighters() throws SQLException {
        List<Fighter> result = new ArrayList<Fighter>();
        String sql = "SELECT * FROM FL_FIGHTERS";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
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

    private Connection getConn() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, "root", "");
        return conn;
    }

    public static void main(String[] a) {
        FighterServiceImpl inst = new FighterServiceImpl();
        try {
            List<Fighter> list = inst.listAllFighters();
            for (Fighter fighter : list) {
                System.out.println(fighter.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
