package Seminar2;
public class Main {
    public static
    void main(String[] args) {
        Cat[] cats = {new Cat("Кузя", 50), new Cat("Вася", 20), new Cat("Тоша", 25)};

Plate plate = new Plate( 80);
 
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
    }
}
