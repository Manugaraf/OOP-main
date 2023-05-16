package Seminar2;
import static java.lang.System.*;
public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;
 
    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }
 
    void info() {
        String isHungry = !hungry ? "сыт" : "голоден";
        out.println(name + ": " + isHungry);
    }
 
    void eat(Plate plate) {
        if (hungry && plate.decreaseFood(appetite))
            hungry = false;
    }
}
