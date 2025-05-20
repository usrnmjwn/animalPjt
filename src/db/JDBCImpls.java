package db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import animalspecies.Reptils;

// DB 관련 CRUD 메서드 작성
public class JDBCImpls {

    public void executeJDBC(String tableName) {
        try {
            // reptile
            Connection conn = JDBCUtils.getConnection();
            String sql = String.format("SELECT ID, NAME, ANIMALTYPE, ANIMALFAMILY, PARKAREA FROM %s",tableName);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Reptils> reptiles = new ArrayList<>();

            // Read
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String type = rs.getString("ANIMALTYPE");
                String family = rs.getString("ANIMALFAMILY");
                String parkArea = rs.getString("PARKAREA");

                // 2) DTO 객체 생성
                Reptils reptile = new Reptils(id, name, type, family, parkArea);

                // 3) 리스트에 추가
                reptiles.add(reptile);

                System.out.printf("%s  ||  %s  ||  %s  에 위치 \n",
                    name, type, family, parkArea
                );
                System.out.println();
            }

            System.out.println("-----실행완료-----------");

        } catch (Exception e) {
            e.printStackTrace();
        }

    };
    


    public void deleteInfo(){

    }

    public void updateInfo() {

    }

}

