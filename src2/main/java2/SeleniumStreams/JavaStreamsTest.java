package SeleniumStreams;

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
//        print all of the names in the array list
        names.stream().filter(s -> s.length() > 4).forEach(System.out::println);
    }

    public static ArrayList<String> createFakeArrListOfNames() {
        String[] names = {"Alice", "Bob", "Susie", "Adam", "Stephanie"};
        return new ArrayList<>(Arrays.asList(names));
    }
}
