package SeleniumStreams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);
    }

    public static ArrayList<String> createFakeArrListOfNames() {
        String[] names = {"Alice", "Bob", "Susie", "Adam", "Stephanie"};
        return new ArrayList<>(Arrays.asList(names));
    }
}
