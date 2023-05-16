package Seminar2;
import static java.lang.System.*;
public class Plate {
    public int food;
    public Plate(int food) {
        this.food = food;
    }
 
 
    boolean decreaseFood(int n) {
        int diff = food - n;
        if (diff < 0) return false;
 
        food -= n;
        return true;
    }
    void addFood(int food) {
        this.food += food;
    }
 
    void info() {
        out.println("plate: " + food);
    }
}
