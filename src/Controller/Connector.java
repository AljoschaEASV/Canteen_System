package Controller;

import Model.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {

    Connection con;

    public java.sql.Connection createConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sample", "sa", "123456");
        } catch (ClassNotFoundException var2) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, var2);
        } catch (SQLException var3) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, var3);
        }

        return con;
    }
}
