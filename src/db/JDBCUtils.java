package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {


    public static Connection getConnection() {
        try {
            String url = "jdbc:oracle:thin:@//localhost:1521/XE";
            String user = "bituser";
            String password = "bituser";
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결 설정
            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
