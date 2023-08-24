package SeleniumStreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class JavaStreamsTest {
    @Test
    public void regular() {
        ArrayList<String> names = createFakeArrListOfNames();
        int count = 0;

        for (String s : names) {
            if (s.startsWith("A")) {
                count++;
            }
        }

        System.out.println(count);
        System.out.println();
    }

    //    lambda expression with stream to condense the code into something much cleaner
    @Test
    public void streamFilter() {
        ArrayList<String> names = createFakeArrListOfNames();
//        this will not modify the original stream
        long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

//        long count2 = Stream.of("Alice", "Bob", "Susie", "Adam", "Stephanie").filter(s -> {
//            s.startsWith("A");
//            return false;
//        }).count();

//        print all the names in the array list
//        names.stream().filter(s -> s.length() > 4).forEach(System.out::println);

//        we can limit the amount of names that it will print
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(System.out::println);
        System.out.println();
    }

    @Test
    public void streamMap() {
        ArrayList<String> names = createFakeArrListOfNames();
//        convert the names that end with e to uppercase and print them
        System.out.println("not sorted:");
        names.stream().filter(s -> s.endsWith("e"))
//                .map(s -> s.toUpperCase()) // this is the old way of doing lambda expression
                .map(String::toUpperCase) // this is the new way of doing the method reference
                .forEach(System.out::println);

//        print the name which have the first letter of a with uppercase and sorted
        System.out.println("sorted:");
        names.stream().filter(s -> s.startsWith("A")).sorted().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void concatStreams() {
//        merging two different array lists using stream
        ArrayList<String> names = createFakeArrListOfNames();
        ArrayList<String> namesDuplicate = createFakeArrListOfNames();

        Stream<String> namesConcatenated = Stream.concat(names.stream(), namesDuplicate.stream());
//        namesConcatenated.sorted().forEach(System.out::println);

//        we can use match to check if any names equal adam, it will assert true if the condition is met
        boolean flagTheName = namesConcatenated.anyMatch((s -> s.equalsIgnoreCase("AdAm")));
//        if we were to assert false here it would throw an error, then we would have to debug
        Assert.assertTrue(flagTheName);
    }

    public static ArrayList<String> createFakeArrListOfNames() {
        String[] names = {"Alice", "Bob", "Susie", "Adam", "Stephanie"};
        return new ArrayList<>(Arrays.asList(names));
    }
}
