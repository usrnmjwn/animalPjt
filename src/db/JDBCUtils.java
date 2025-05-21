package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {


    public static Connection getConnection() {
        try { 
            // 문자셋 옵션 추가
            String url = "jdbc:oracle:thin:@//localhost:39161/XE";
            String user = "zoo";
            String password = "1234";
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결 설정
            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
