import db.JDBCImpls;
import java.util.Map;
import java.util.Scanner;

public class AnimalManager {
    public static Scanner sc;
    public static Map<Integer, String> map;

    // 1번 테이블 내 전체 동물 조회 
    private void findAllAnimals() {
        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.println("조회를 원하는 번호를 입력하세요");
        System.out.println();
        System.out.println(">> 1. 포유류 ");
        System.out.println(">> 2. 조류 ");
        System.out.println(">> 3. 파충류 ");
        System.out.println(">> 4. 양서류 ");
        System.out.println(">> 0. 종료");

        boolean isRun = true;
        sc = new Scanner(System.in);

        while (isRun) {
            int num = sc.nextInt();
            JDBCImpls oj = new JDBCImpls();
            switch (num) {
                case 1 -> oj.readAllData("Mammals");
                case 2 -> oj.readAllData("Birds");
                case 3 -> oj.readAllData("Reptiles");
                case 4 -> oj.readAllData("Amphibians");
                case 0 -> isRun = false;
                default -> System.out.println("잘못된 입력입니다");
            }

        }

    }

    // 2번 특정 동물 정보 조회 
    private void findAnimal() {
        // TODO: 나중에 삭제
        // JDBCImpls oj = new JDBCImpls();
        // System.out.println("사자 비슷한거 찾기");
        // oj.readSimilarData("Mammals", "사자");
    }

    // 3번 새로운 동물 정보 추가
    private void addAnimalInfo() {
        // JDBCImpls oj = new JDBCImpls();
        // TODO: 나중에 삭제

        // System.out.println("포유류에 추가");
        // oj.createData("Mammals", "이름", "o", "b", "l");

        // 특정 정보 조회
        // System.out.println("조회");
        // oj.readOneData("Mammals", "캘리포니아바다사자");

        // 조회 후 수정 (id로 가져와서 나머지 정보 수정)
        // System.out.println("수정");
        // oj.updateData("Mammals",110, "이름1", "o1", "b1", "l1");

        // 삭제
        // System.out.println("삭제");
        // oj.deleteData("Mammals", "이름");

    }
    
    public void run() {
        boolean isRun = true;

        while (isRun) {
            System.out.println("-----------------------------------------------");
            System.out.println();
            System.out.println("*** 원하는 번호를 입력하세요 ***");
            System.out.println();
            System.out.println(">> 1. 전체 동물 목록 조회");
            System.out.println(">> 2. 동물 정보 조회");
            System.out.println(">> 3. 새로운 동물 추가");
            System.out.println(">> 0. 종료");

            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("전체 동물 목록 조회");
                    System.out.println();
                    findAllAnimals();
                    break;
                case 2:
                    System.out.println("동물 정보 조회"); 
                    System.out.println();
                    findAnimal();
                    break;
                case 3:
                    System.out.println("새로운 동물 추가"); 
                    System.out.println();
                    addAnimalInfo();
                    break;
                case 0:
                    System.out.println("종료");
                    isRun = false;
                    sc.close();
                    break;
                default:
                    System.out.println("잘못된 입력입니다");
                    break;
            }

        }
    }

}
