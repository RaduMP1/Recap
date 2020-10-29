package fundamentals;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        System.out.println("Hello Radu");
//        System.out.println("some text");
//        System.out.println("linie noua in main");
        Animal animal = new Cat();
        animal.walk();
        System.out.println(animal.n);

        System.out.println(10 * 20 + "Javatpoint");
        System.out.println("Javatpoint" + 10 * 20);
        System.out.println("Javatpoint" + 10 + 20);

        String s1 = "Ana";
        String s2 = "Ana";
        String s3 = new String("Ana");
        String s4 = new String("Ana");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s3.equals(s4)); //true

        ImmutableClass immutableObject = new ImmutableClass(3, "a");
//        immutableObject.x = 3;
//        System.out.println(immutableObject.x);
//        immutableObject.x = 5;
        System.out.println(immutableObject.getX());


    }
}
