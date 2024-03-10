package lesson24;

import java.sql.*;

public class JdbcApp {

    public static Connection connection;
    public static Statement stmt;
    private static final String DATA_FILE = "C:/Users/solya/Cohort42.1/sqlite_db";

    public static void connect() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATA_FILE);
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add(String name, String groupName, Statement stmt) throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, group_name) VALUES ('" + name + "', '" + groupName + "')");
    }

    public static void read(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM students;");
        while ((rs.next())) {
            System.out.println(
                    rs.getInt(1) + ", " +
                            rs.getString(2) + ", " + rs.getString(3)
            );
        }
    }

    public static void delete(int id, Statement stmt) throws SQLException {
        // TODO implement delete by id
        stmt.executeUpdate("DELETE FROM students WHERE id = " + id + ";");
    }

    public static void update(String name, String group_name, Statement stmt) throws SQLException {
        // TODO implement update group_name by
        stmt.executeUpdate("UPDATE students SET group_name = '" + group_name + "' WHERE name = '" + name + "';");
    }
}
