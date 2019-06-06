package tec.ac.cr.extraclase5.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHolderData {

    public static String ip = "";

    public static Connection getDatabaseData() throws SQLException {
        String data = "jdbc:sqlserver://" + ip + ":1433;database=Lapiceros;user=SA;password=Qwerty12345@;";
        Connection conn = DriverManager.getConnection(data);
        return conn;
    }
}
