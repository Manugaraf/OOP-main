package Seminar4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Box<Apple> box1 = new Box<>();
        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());
        System.out.println("Вес коробки №1: " + box1.getWeight());
        System.out.println("В коробке Box1 хранятся " + box1.getProduct().get(0).getClass().getSimpleName());

        Box<Orange> box2 = new Box<>();
        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());
        System.out.println("Вес коробки №2: " + box2.getWeight());
        System.out.println("В коробке Box2 хранятся " + box2.getProduct().get(0).getClass().getSimpleName());

        Box<Apple> box3 = new Box<>();
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("В коробке Box3 хранятся " + box3.getProduct().get(0).getClass().getSimpleName());
        
        
        System.out.println("Массы коробок 1 и 2 " + (box1.compare(box2) ? "одинаковы" : "различны") + ".");
        System.out.println("Массы коробок 1 и 3 " + (box1.compare(box3) ? "одинаковы" : "различны") + ".");

        box1.AddAnItem(box3);
        System.out.println("Вес коробок 3: " + box3.getWeight());
        System.out.println("Вес коробок 1: " + box1.getWeight());


        try {
            box3.add(new Orange());
                       box3.add(new Orange());
                       box3.add(new Orange());
            } catch (BoxCustomException e) {
                       System.out.println(e);
                   }
            System.out.println("Вес коробки №3: " + box3.getWeight());


    }
}

abstract class Fruit{

    private final float weight;

    public float getWeight() {
        return weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}

class Apple extends Fruit {

    public Apple() {
        super(1.0f);
    }
}

class Orange extends Fruit {

    public Orange() {
        super(1.5f);
    }
}





class Box<T extends Fruit>{

    ArrayList<T> fruits;
    private ArrayList<Fruit> product = new ArrayList<>();


    public double getWeight() {
        double sumWeightProducts = 0.0f;
        for (Fruit e : product) {
            sumWeightProducts += e.getWeight();
        }
        return sumWeightProducts;
    }
   
    public ArrayList<Fruit> getProduct() {
        return product;
    }
   
    public void add(Fruit fruit) {
        if (product.size() > 1) {
            if (isProductsComparable(fruit)) {
                throw new BoxCustomException("Внимание! Смешивать товары запрещено, используйте другой товар или коробку!");
            }
        }
        product.add(0, fruit);
    }
   
    
    public boolean compare(Box other) {
        return Math.abs(getWeight() - other.getWeight()) < 0.0001; 
    }
   
    
    public void removeSingleItem() {
   
    }
   
    
    public void AddAnItem(Box box2) throws BoxCustomException {
        if (isProductsComparable(box2)) {
            throw new BoxCustomException("Внимание! Смешивать товары запрещено, используйте другой товар или коробку!");
        }
        
        for (int i = product.size() - 1; i >= 0; i--) {
            box2.getProduct().add(product.get(i));
            product.remove(i);
        }
    }
   
    
    public boolean isProductsComparable(Box otherBox) {
        return product.get(0).getClass() != otherBox.getProduct().get(0).getClass();
    }
   
    
    public boolean isProductsComparable(Fruit fruit) {
        return product.get(0).getClass() != fruit.getClass();
    }
}

class BoxCustomException extends RuntimeException{
    public BoxCustomException(String message) {
    super(message);
    }
}

