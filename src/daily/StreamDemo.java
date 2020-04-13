package daily;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        Stream.generate(new PersonSupplier())
                .limit(10)
                .forEach(cur -> System.out.println(cur.toString()));
        List<Integer> generated = Stream.iterate(2, n -> n * 2)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(generated);

        Map<Integer, List<MyPerson>> personGroups = (Map<Integer, List<MyPerson>>) Stream
                .generate(new PersonSupplier())
                .limit(100)
                .collect(Collectors.groupingBy(MyPerson::getAge));

        Iterator it = personGroups.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<MyPerson>> persons = (Map.Entry<Integer, List<MyPerson>>) it.next();
            System.out.println("Age " + persons.getKey() + "=" + persons.getValue().size());
        }

        Map<Boolean, List<MyPerson>> children = (Map<Boolean, List<MyPerson>>) Stream
                .generate(new PersonSupplier())
                .limit(100)
                .collect(Collectors.partitioningBy((MyPerson p) -> {
                    if (p.getAge() < 18)
                        return true;
                    return false;
                }));

        System.out.println(children.get(true).size());
        System.out.println(children.get(false).size());


        List<Integer> integers = Arrays.asList(1, 4, 5, 2, 3, 4, 7, 9, 10);

        Integer sum = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);


        IntSummaryStatistics stat = integers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(stat.getSum());
        List<String> strs = Arrays.asList("abc", null, "bcd");
        Optional.ofNullable(strs.get(1)).ifPresent(System.out::println);
        int length = Optional.ofNullable(strs.get(1)).map(String::length).orElse(-1);
        System.out.println(length);


        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        IntStream outputStream = inputStream.
                flatMap((childList) -> childList.stream()).mapToInt(x -> x);
        outputStream.forEach(cur -> System.out.println(cur + ","));


        IntStream.range(0, 10).forEach(System.out::print);
        IntStream.rangeClosed(0, 10).forEach(System.out::print);


        List<String> nums = Arrays.asList("1", "5", "3", "2", "68");
        String[] arr = nums.stream().toArray(String[]::new);
        Stack stack = nums.stream().collect(Collectors.toCollection(Stack::new));
        List list1 = nums.stream().collect(Collectors.toList());
        List list2 = nums.stream().collect(Collectors.toCollection(ArrayList::new));


        System.out.println(nums);

        List<String> nums1 = nums;
        List<String> nums2 = nums;
        List<String> nums3 = nums;
        Collections.sort(nums1, (s1, s2) -> s2.compareTo(s1));
        System.out.println(nums1);
        Collections.sort(nums2, (s1, s2) -> s1.compareTo(s2));
        System.out.println(nums2);
        Collections.sort(nums3, (s1, s2) -> -s1.compareTo(s2));
        System.out.println(nums3);


        integers.stream().distinct().map(x -> x + ",").forEach(System.out::print);


        List<String> list = Arrays.asList("a", "ab", "bcd", "", "", "abb", "dd");
        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::print);

        String merged = list.stream().filter(cur -> !cur.isEmpty()).collect(Collectors.joining("\t"));
        System.out.println(merged);
        String mergedByP = list.parallelStream().filter(cur -> !cur.isEmpty())
                .collect(Collectors.joining(","));
        System.out.println(mergedByP);

        Stream<String> stream = list.stream();

        long count = stream.filter(cur -> {
            if (cur.contains("a"))
                return true;
            return false;
        }).count();
        System.out.println(count);


    }
}
