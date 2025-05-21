import animalspecies.Amphibians;

public class App {
    public static void main(String[] args) {
        // Amphibians 객체 생성
        Amphibians frog = new Amphibians("두꺼비", "양서류", "두꺼비과", "양서류관");

        // 정보 출력
        System.out.println("=== 동물 정보 ===");
        frog.showInfo();

        // 행동 실행
        System.out.println("\n=== 행동 실행 ===");
        frog.walk();
        frog.swim();
    }
}