package advanced.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsEx {

    public static void main(String[] args) {

        //ex 1
        List<String> names = Arrays.asList("Dacia", "BMW", "Toyota");
        Stream<String> namesStream = names.stream(); // cream stream-ul in baza listei 'names' de la randul 14
        List<String> namesFromStream = namesStream.collect(Collectors.toList()); // construim inapoi lista de String-uri din stream-ul pe care il avem: cu collect() colectam datele din stream si le punem in lista namesFromStream
        System.out.println(namesFromStream);    //printam lista
//        System.out.println(namesStream.count());     // numaram cate elemente sunt in stream / Obs. dupa ce se face operatia asta, stream-ul nameStream se inchide si nu mai poate fi folosit in continuare (primim eroare IllegalStateException la randul urmator)
        names.stream().forEach(n -> System.out.println(n));    // sa printam fiecare element din stream (forEach primeste ca si parametru un consumer) / Obs. am construit stream-ul din nou cu "names.stream()" ca sa ocolim eroarea descrisa la Obs de la randul 18

        //next ex - findFirst: sa gasim primul element din lista
        Optional<String> firstElement = names.stream().findFirst(); // cream un Optional de String / din nou cu names.stream() tre sa construim stream-ul, ca l-am folosit mai sus si s-a inchis
        if (firstElement.isPresent()) {  //cu metoda isPresent() care tine de Optional, verificam daca firstElement exista
            System.out.println(firstElement.get());  // cu get() luam valoarea lui firstElement
        }

        // ex cu findAny()
        Optional<String> elem = names.parallelStream().findAny();  // parallelStream() face sa nu mearga in aceeasi ordine datele prin stream (ca si primul stream) ci asa cum vrea JVM-ul sa mearga
        if (elem.isPresent()) {
            System.out.println(elem.get());
        }

        System.out.println("####################################################################");

        //next - using filter (pdf 06_Java Adv pag 119) / film Recap9 : 03:27 / folosim un filtru care ne returneaza o lista de elemente care se termina cu a.
        List<String> endsWithAElements = names.stream()  // facem stream-ul de pe lista de names (lista names de mai sus la randul 14)
//                .peek(System.out::println)    // ca sa vezi cum arata stream-ul tau la un anumit moment / peek() este metoda a lui Stream, ce ia un consumer, sysout e aici in rol de consumer
                .filter(n -> n.endsWith("a"))   // aplicam un filtru pe names.stream() / filter() face parte din metodele lui Stream / filtrul primeste un predicate, deci facem un Lambda pt un predicate - care da un boolean: verifica ca numele se termina cu 'a')
                .peek(System.out::println)  // ca sa vedem lista dupa ce am facut filtrarea
                .collect(Collectors.toList());  // dupa ce am filtrat, colectam datele / collect() e metoda a lui Stream
        // OBs. ref randurile 37,38,39 - filter-ul interfereaza cu peek-urile si e posibil ca peek-urile sa se afiseze intercalate (film Recap9 03:34:25)


        // next ex - filtram dupa cuvinte ce se termina cu 'a' si afisam numarul de litere pt toate cuvintele ce se termina cu 'a' din lista respectiva
        List<Integer> countLetters = names.stream()
//                .peek(System.out::println)
                .filter(n -> n.endsWith("a")) // filtram dupa cuvintele ce se termina cu 'a'
                .map(String::length)  // transformam String-ul intr-un int: Mapam de la String la int cu ajutorul lui length(), pt ca length returneaza int (mapam lungimea Stringurilor) / varianta fara method reference ar fi: .map(n -> n.length())
                .peek(System.out::println)
                .collect(Collectors.toList()); // pune rezultatul in lista
        System.out.println(countLetters); // returneaza : [5,6] , adica lista cu lungimea fiecarui cuvant din String, ce se termina cu litera 'a'


        //calculati suma literelor din lista de nume pe care o avem
        int countAllCharacters = names.stream()
                .mapToInt(String::length).sum();
        System.out.println(countAllCharacters);


        System.out.println("----------------------------");

        //next - Reducer (pdf 06_Java Advanced, pag 121 / film Recap9 04:12~
        // sa concateneze numele din lista names intr-o lista separata cu virgula intre ele
        String concatenatedNames = names.stream()  // rezultatul va fi un String
                .reduce("", (currentValue, element) -> currentValue.isEmpty() ? currentValue + element
                        // accumulator-ul pt ca vrem sa returnam un String, va fi un String gol, adica punem ""  /
                        // (currentValue, element) al 2lea parametru al reducerului e un BiFunction sau un binary operator:
                        // va primi 2 valori: currentValue - adica ce are reducer-ul nostru in momentul asta ca si valoare,
                        // respectiv a 2a valoare va fi elementul din Stream
                        // -> currentValue.isEmpty() ? currentValue + element / daca valoarea noastra este empty
                        // vom adauga elementul (la valoare empty), altfel ii vom adauga "," si elementul
                        : currentValue + ", " + element);
        System.out.println(concatenatedNames);

    }
}
