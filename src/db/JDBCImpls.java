package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// DB 관련 CRUD 메서드 작성
public class JDBCImpls {

    // 정보 받아 저장
    public void createData(String tableName, String name, String ordinal, String branch, String location) {
        try {
            String sql = String.format("INSERT INTO %s (NAME, ORDINAL, BRANCH, LOCATION) VALUES (?, ?, ?, ?)",
                    tableName);
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, ordinal);
            pstmt.setString(3, branch);
            pstmt.setString(4, location);

            pstmt.executeUpdate();

            System.out.println("저장되었습니다");

        } catch (Exception e) {
            System.out.println("data 저장 과정에서 에러 발생");
            e.printStackTrace();
        }

    }

    // 전체 조회
    public void readAllData(String tableName) {
        try {
            String sql = String.format("SELECT ID, NAME, ORDINAL, BRANCH, LOCATION FROM %s", tableName);
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("-----------------------------------------------");
            System.out.println();
            System.out.printf("[ %s 정보 전체 조회 ]", tableName);
            System.out.println();
            
            while (rs.next()) {
                String name = rs.getString("NAME");
                String ordinal = rs.getString("ORDINAL");
                String branch = rs.getString("BRANCH");
                String location = rs.getString("LOCATION");

                System.out.printf("%s  ||  %s  ||  %s  ||  %s 에 위치 \n",
                        name, ordinal, branch, location);
            }

        } catch (Exception e) {
            System.out.println("data 조회 과정에서 에러 발생");
            e.printStackTrace();
        }

    };

    // 이름으로 동일 정보 조회
    public void readOneData(String tableName, String name) {
        try {
            String sql = String.format(
                    "SELECT * FROM %s WHERE NAME LIKE ?",
                    tableName);
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("해당 이름의 동물 정보가 존재하지 않습니다");
            } else {
                System.out.println("-----------------------------------------------");
                System.out.println();
                System.out.printf("[ %s 동물 정보 조회 ]\n", name);
                System.out.println();
                do {
                    String id = rs.getString("ID");
                    String dataName = rs.getString("NAME");
                    String ordinal = rs.getString("ORDINAL");
                    String branch = rs.getString("BRANCH");
                    String location = rs.getString("LOCATION");

                    System.out.printf("ID: %s  ||  %s  ||  %s  ||  %s  ||  %s 에 위치 \n",
                            id, dataName, ordinal, branch, location);
                } while (rs.next()); // 다음 행이 있으면 반복
            }

        } catch (Exception e) {
            System.out.printf("%s 조회 과정에서 에러가 발생했습니다", name);
            e.printStackTrace();
        }
    }

    // 비슷한 이름름 조회
    public void readSimilarData(String tableName, String name) {

        System.out.println(name);
            try {
                String sql = String.format(
                        "SELECT * FROM %s WHERE NAME LIKE ?",
                        tableName);
                Connection conn = JDBCUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + name + "%");
                ResultSet rs = pstmt.executeQuery();

                if (!rs.next()) {
                    System.out.println("해당 이름의 동물 정보가 존재하지 않습니다");
                } else {
                    System.out.println("-----------------------------------------------");
                    System.out.println();
                    System.out.printf("[ %s 동물 정보 조회 ]\n", name);
                    System.out.println();
                    do {
                        String id = rs.getString("ID");
                        String dataName = rs.getString("NAME");
                        String ordinal = rs.getString("ORDINAL");
                        String branch = rs.getString("BRANCH");
                        String location = rs.getString("LOCATION");

                        System.out.printf("ID: %s  ||  %s  ||  %s  ||  %s  ||  %s 에 위치 \n",
                                id, dataName, ordinal, branch, location);
                    } while (rs.next()); // 다음 행이 있으면 반복
                }

            } catch (Exception e) {
                System.out.printf("%s 조회 과정에서 에러가 발생했습니다", name);
                e.printStackTrace();
            }
        }

    // 이름으로 삭제
    public void deleteData(String tableName, String name) {
        try {
            String sql = String.format("DELETE FROM %s WHERE NAME = ?", tableName);
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.executeUpdate();

            System.out.println("삭제되었습니다");

        } catch (Exception e) {
            System.out.println("data 삭제 과정에서 에러 발생");
            e.printStackTrace();
        }
    }

    // id 로 찾아서 수정
    public void updateData(String tableName, int id, String name, String ordinal, String branch, String location) {
        try {
            String sql = String.format(
                    "UPDATE %s SET NAME = ?, ORDINAL = ?, BRANCH = ?, LOCATION = ? WHERE ID = ?",
                    tableName);
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, ordinal);
            pstmt.setString(3, branch);
            pstmt.setString(4, location);
            pstmt.setInt(5, id);

            pstmt.executeUpdate();

            System.out.println("수정되었습니다");
        } catch (Exception e) {
            System.out.println("data 수정 과정에서 에러 발생");
            e.printStackTrace();
        }
    }

}
