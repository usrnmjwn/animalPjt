package animalspecies;

import animal.Animal;
import animal.Walk;
import animal.Swim;

public class Amphibians extends Animal implements Walk, Swim {

    public Amphibians(String name, String ordinal, String branch, String location) {
        super(name, ordinal, branch, location);
    }

    @Override
    public void walk() {
        System.out.println(name + "는 느릿느릿 걷습니다.");
    }

    @Override
    public void swim() {
        System.out.println(name + "가 물속에서 헤엄칩니다.");
    }
}