package advanced.lambda;


import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class StartLambda {

    public static void main(String[] args) {

        // ex1 v1 - fara Lambda
        Person person = new Person(26, "Ion", "Popescu");
        Predicate<Person> adultTest = new AdultPersonTest();
        System.out.println(adultTest.test(person));

        //ex1 v2 - cu Lambda si predicate
        Person person2 = new Person(12, "Maria", "Popescu");
        Predicate<Person> lambdaAdultTest = personX -> personX.getAge() >= 18;
        System.out.println(lambdaAdultTest.test(person2));

        // ex. cu Runnable
        Runnable runnableExample = () -> System.out.println("This is now running");
        runnableExample.run();  // metoda run() a lui Runnable va executa sysout-ul "This is now running"

        // ex2 cu lambda si predicate
        Predicate<String> endsWithTest = s -> s.endsWith("ant");
        System.out.println(endsWithTest.test("restaurant"));   //functia test() apartine de Predicate

        // ex3 lambda cu function interface
        Function<String, Integer > stringLengthFunction = s -> s.length();
        System.out.println(stringLengthFunction.apply("ABCDE"));   //functia apply() apartine de Function

        //ex 4 function care sa ia varsta
        Function<Person, Integer> getAgeFunction = personY -> personY.getAge();
        System.out.println(getAgeFunction.apply(person2));
        System.out.println(getAgeFunction.apply(person));


        //exerc Supplier (pdf 06_Java_Advanced pag. 109)
        Supplier<Integer> takeRandomInt = () -> new Random().nextInt();   // un supplier
        Supplier<Person> createPerson = () -> new Person(35, "Johny","Chips"); // inca un supplier
        Supplier<Integer> takeAnotherRandomInt = () -> 3 ;
        System.out.println("Supplier output: " + takeRandomInt.get());
        System.out.println("Person Supplier output: " + createPerson.get());
        System.out.println("Another Supplier output: " + takeAnotherRandomInt.get());


        //exerc Consumer (pdf 06_Java_Advanced pag. 109)
        Consumer<Integer> printNumber = number -> System.out.println("Consumer will print " + number); // un consumer
        printNumber.accept(123);  //apelam consumerul cu metoda accept() ca sa ii dam parametrul
        Consumer<Person> printAge = aPerson -> System.out.println(aPerson.getAge());   // un alt consumer de tip Person
        printAge.accept(new Person(30, "Lee", "Chang")); // apelam consumerul. ca parametru tre sa ii cream o persoana, cu new


        // exerc Consumer cu body . in bloc nu va avea return pt ca este consumer, iar consumerii nu au return
        Consumer<Person> bodyConsumer = person3 -> {
            person3.setAge(person3.getAge() + 5);   //varianta in care folosim setter sa schimbam varsta persoanei
            System.out.println(person3);
//            System.out.println("Peste 5 ani persoana va avea varsta: " + (person3.getAge() + 5)); //varianta in care nu schimbam varsta persoanei ci doar afisam cat va fi varsta in 5 ani. Se foloseste alternativ cu linia 60
        };                                                                                        // obs ca in linia 62 (person.getAge() + 5) e intre paranteze. Asta ca sa faca intai operatia de adunare si sa nu concateneze cu textul din fata
        Person adult = new Person(25, "Leo", "Messi");
        System.out.println(adult);
        bodyConsumer.accept(adult);  // apeleaza bodyConsumer de mai sus


        //exerc UnaryOperator (pdf 06_Java_Advanced pag. 110)
        UnaryOperator<Double> squareDouble = d -> Math.pow(d,2);  // primeste un parametru d. La return, in metoda pow() primeste parametrul si puterea la care vrem sa il ridicam
        System.out.println("Square for 4.0 is " + squareDouble.apply(4.0));


        //exerc Method Reference => facem Method Reference la un Function. Va lua un parametru de tip Person si va returna unul de tip Integer, pt ca vrem sa returnam varsta persoanei
        //este varianta cu Method Reference a exercitiul 4 de la randul 34 (care e aceeasi functie dar facuta cu Lambda, nu cu Method Reference)
        Function<Person, Integer> getAgeWithReference = Person::getAge;
        System.out.println(getAgeWithReference.apply(adult));  //apelam function-ul cu metoda apply si ii dam ca parametru adult-ul de la randul 64


        // Tema de casa - pag 112
        //Create and present the usage of lambda expressions:
        // a) Addition, subtraction, multiplication, division.
        BinaryOperator<Integer> suma = Integer::sum;  // in varianta fara method reference: BinaryOperator<Integer> suma = (a,b) -> a+b;
        System.out.println("suma lui a+b este " + suma.apply(1,2));

        BinaryOperator<Integer> substraction = (a,b) -> a-b;
        System.out.println("a-b este egal cu " + substraction.apply(2,2));

        // b) The sum of elements (int type) of the list.  (il facem cu un Lambda cu body, adica care are acolade)
        List<Integer> listOfElements = Arrays.asList(1,2,3,4,5,6,7);
        Function<List<Integer>,Integer> sum = lista -> {
          int variabilaPtSuma = 0;
            for (Integer integer : lista) {   // asta e varianta cu for each (numit si 'enhanced for'. Varianta cu 'for' simplu ar fi: for (int i = 0; i < lista.size(); i++) {
                variabilaPtSuma += integer;  // in varianta lui for clasic, ar fi: variabilaPtSuma += lista.get(i); // cu lista.get(i) selectam valoarea fiecarui element din lista
            }
            return variabilaPtSuma;
        };
        System.out.println("suma elementelor din listOfElements este: " + sum.apply(listOfElements));


        // c) Number of words in the input expression (list containing elements of type String) / il facem cu method reference
        List<String> listOfStringElements = Arrays.asList("masina", "casa", "caine", "job", "pisica");
        Function<List<String>, Integer> numberOfWords = List::size; // varianta fara method reference: Function<List<String>, Integer> numberOfWords = listOfStrings -> listOfStrings.size();
        System.out.print("numarul de cuvinte din lista de stringuri este: ");
        System.out.println(numberOfWords.apply(listOfStringElements));


        // d)* List before and after sorting (use the Arrays class and lambda expressions:
        // String :: compareToIgnoreCase as a comparator)
        List<String> stringElements = Arrays.asList("masina", "casa", "caine", "job", "pisica");
        System.out.println("lista elementelor este: " + stringElements);
        Consumer<List<String>> sortList = listOfStrings -> listOfStrings.sort(String::compareToIgnoreCase);
        sortList.accept(stringElements);
        System.out.println(stringElements);

        // pana aici Tema de casa (pag 112 in pdf Java Advanced)



    }
}
