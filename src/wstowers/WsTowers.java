package wstowers;

import com.mysql.jdbc.Connection;

/**
 *
 * @author Administrador
 */
public class WsTowers {

    private final String url = "jdbc:mysql://localhost:3306/wstowers";
    private final String user = "root";
    private final String password = "root";

    public static Connection conn;

    public static Connection getConexao() {
        if (conn == null) {
        }
    }
}
