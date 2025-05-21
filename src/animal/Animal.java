package animal;

public class Animal {
    protected String name;        // 동물 이름
    protected String ordinal;     // 목분류
    protected String branch;      // 과분류
    protected String location;    // 공원 내 위치

    public Animal(String name, String ordinal, String branch, String location) {
        this.name = name;
        this.ordinal = ordinal;
        this.branch = branch;
        this.location = location;
    }

    // getter
    public String getName() {
        return name;
    }

    // 공통 정보 출력
    public void showInfo() {
        System.out.println("🐾 동물 정보");
        System.out.println("이름: " + name);
        System.out.println("목분류: " + ordinal);
        System.out.println("과분류: " + branch);
        System.out.println("공원 내 위치: " + location);
    }
}