package fundamentals;

public class Animal {
    String color;
    int n;
    Object obj;

    public Animal(){
        this("black");
    }

    Animal(String color) {
        this.color = color;
    }

    public static void walk(){
        System.out.println("fundamentals.Animal walks");
    }
}
