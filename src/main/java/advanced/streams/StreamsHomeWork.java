package advanced.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsHomeWork {

    static List<String> names = Arrays.asList("John", "Sarah", "Mark", "Tyla", "Ellisha", "Eamonn");


    public static void main(String[] args) {

//        Using streams, for a given list:
//                - [„John”, „Sarah”, „Mark”, „Tyla”, Ellisha ”, Eamonn]
//                - [1, 4, 2346, 123, 76, 11, 0, 0, 62, 23, 50]
//                a) Sort the list.

        Stream<String> namesStream = names.stream().sorted();
        List<String> namesFromStream = namesStream.collect(Collectors.toList());
        System.out.println(namesFromStream);


//        b) Print only those names, that start with „E” letter

        Stream<String> namesThatStartWithE = names.stream().filter(n -> n.startsWith("E"));
        List<String> namesFromStreamThatStartWithE = namesThatStartWithE.collect(Collectors.toList());
        System.out.println(namesFromStreamThatStartWithE);


//        c)  Print values greater than 30 and lower than 200.

        List<Integer> someNumbers = Arrays.asList(1, 4, 2345, 123, 76, 11, 0, 0, 62, 23, 50);
        List<Integer> numbersList = someNumbers.stream()
                .filter(n -> n > 30)
                .filter(n -> n < 200)
                .collect(Collectors.toList());
        System.out.println(numbersList);


//        d) Print names uppercase

        List<String> namesToUppercase = names.stream()
                .map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(namesToUppercase);


//        e) Remove first and last letter , sort and print names

        List<String> shortNames = names.stream()
                .map(n -> n.substring(1, n.length() - 1))
                .sorted().collect(Collectors.toList());
        System.out.println(shortNames);


//        f)*Sort backwards by implementing reverse Comparator and using lambda expression

        Comparator<String> comp = (aName, bName) -> aName.compareTo(bName);
        List<String> backwardsList = names.stream().sorted(comp.reversed()).collect(Collectors.toList());
//        List<String> backwardsList = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(backwardsList);


    }
}
