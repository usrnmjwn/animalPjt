import db.JDBCImpls;
import db.JDBCUtils;
import java.util.Map;
import java.util.Scanner;

public class AnimalManager {
    public static Scanner sc;
    public static JDBCUtils oj;
    public static Map<Integer, String> map;

    // 생성자에 바로 run 코드 추가
    public AnimalManager() {
        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.println("*** 원하는 번호를 입력하세요 ***");
        System.out.println();
        System.out.println(">> 1. 전체 동물 목록 조회");
        System.out.println(">> 2. 동물 정보 조회");
        System.out.println(">> 3. 새로운 동물 추가");
        System.out.println(">> 0. 종료");
    }


    private void findAllAnimals() {
        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.println("조회를 원하는 번호를 입력하세요");
        System.out.println();
        System.out.println(">> 1. 포유류 ");
        System.out.println(">> 2. 조류 ");
        System.out.println(">> 3. 파충류 ");
        System.out.println(">> 4. 양서류 ");
        System.out.println();
        System.out.println("0. 종료");

        boolean isRun = true;
        sc = new Scanner(System.in);

        while (isRun) {
            int num = sc.nextInt();
            JDBCImpls oj = new JDBCImpls();
            switch (num) {
                case 1 -> oj.readAllData(TableNames.MAMMALS);
                case 2 -> oj.readAllData(TableNames.BIRDS);
                case 3 -> oj.readAllData(TableNames.REPTILES);
                case 4 -> oj.readAllData(TableNames.AMPHIBIANS);
                case 0 -> isRun = false;
                default -> System.out.println("잘못된 입력입니다");
            }

        }

    }

    private void addAnimalInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAnimalInfo'");
    }

    private void findAnimal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAnimal'");
    }

    public void run() {
        boolean isRun = true;

        while (isRun) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("전체 동물 목록 조회"); // findAllAnimals
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
