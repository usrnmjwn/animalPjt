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

            while (rs.next()) {
                String name = rs.getString("NAME");
                String ordinal = rs.getString("ORDINAL");
                String branch = rs.getString("BRANCH");
                String location = rs.getString("LOCATION");

                System.out.println("-----------------------------------------------");
                System.out.println();
                System.out.printf("[ %s 정보 전체 조회 ]", tableName);

                System.out.printf("%s  ||  %s  ||  %s  에 위치 \n",
                        name, ordinal, branch, location);
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("data 조회회 과정에서 에러 발생");
            e.printStackTrace();
        }

    };

    // 비슷한 값 조회
    public void readSimilarData(String tableName, String name) {
        try {
            String sql = String.format(
                    "SELECT * FROM %s WHERE NAME LIKE ?",
                    tableName);
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+name+"%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String dataName = rs.getString("NAME");
                String ordinal = rs.getString("ORDINAL");
                String branch = rs.getString("BRANCH");
                String location = rs.getString("LOCATION");

                System.out.println("-----------------------------------------------");
                System.out.println();
                System.out.printf("[ %s 과 유사한 값 조회 ]", dataName);

                System.out.printf("%s  ||  %s  ||  %s  에 위치 \n",
                        dataName, ordinal, branch, location);
                System.out.println();
            }

        } catch (Exception e) {
        }
    }

    // 삭제
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

    // 수정
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
