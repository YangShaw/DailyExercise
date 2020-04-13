package advancdexercise;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FuncProgramming {

    public static void main(String[] args) {
        Consumer c = System.out::println;

        c.andThen(c).andThen(c).accept("hello world");

        Function<Integer, Integer> f = i -> i + i;
        Function<Integer, Integer> f2 = i -> i * i;
        c.accept(f.andThen(f2).apply(5));

        String[] array = {"1", "2", "bilibili", "of", "shawyoung", "SHAWYOUNG", "abcd"};

        String result = Arrays.stream(array)
                .filter(i -> i.length() >= 5)
                .map(i -> i.toLowerCase())
                .distinct()
                //.collect(Collectors.toList())
                //.toString();
                .collect(Collectors.joining("**"));
        System.out.println(result);

    }
}
