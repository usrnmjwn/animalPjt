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

    // 2번 특정 동물 정보 조회 (이름 검색 기능만)
    private void findAnimal() {
        Scanner sc = new Scanner(System.in);
        JDBCImpls oj = new JDBCImpls();

        System.out.println("검색할 동물의 테이블을 선택하세요.");
        System.out.println(">> 1. 포유류 (Mammals)");
        System.out.println(">> 2. 조류 (Birds)");
        System.out.println(">> 3. 파충류 (Reptiles)");
        System.out.println(">> 4. 양서류 (Amphibians)");
        System.out.print("입력: ");
        int choice = sc.nextInt();
        sc.nextLine(); // 개행 제거

        String tableName = "";
        switch (choice) {
            case 1:
                tableName = "Mammals";
                break;
            case 2:
                tableName = "Birds";
                break;
            case 3:
                tableName = "Reptiles";
                break;
            case 4:
                tableName = "Amphibians";
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        // 검색
        System.out.println("조회");
        System.out.print("검색할 이름 입력: ");
        String keyword = sc.next();

        System.out.println(keyword);
        System.out.println("oj.readsimilar 메서드 실행 전");
        oj.readSimilarData(tableName, keyword);
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
