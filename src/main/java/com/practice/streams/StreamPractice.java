package com.practice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hi", "I'm", "a", "Java", "Backend", "Developer");
        // List<String> res = list.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).toList();
        List<String> sortedStrings = list.stream().sorted(Comparator.comparingInt(String::length)).toList(); // better way
        System.out.println("Sorted Strings : " + sortedStrings);

        List<Integer> numbers = Arrays.asList(2, 6, 1, 4, 3, 8, 7, 2, 1, 2);
        List<Integer> sorted = numbers.stream().sorted().toList();
        System.out.println("Sorted : " + sorted);
        // List<Integer> ascendingOrder = numbers.stream().sorted((Integer s1, Integer s2) -> s1 - s2).toList(); // ascending order
        List<Integer> descendingOrder = numbers.stream().sorted((Integer s1, Integer s2) -> s2 - s1).toList(); // descending order
        System.out.println("DescendingOrder : " + descendingOrder);

        List<Integer> limit = numbers.stream().limit(4).toList();
        System.out.println("Limit : " + limit);

        List<Integer> skip = numbers.stream().skip(3).toList();
        System.out.println("Skip : " + skip);

        int max = numbers.stream().max((o1, o2) -> o1 - o2).get();
        int min = numbers.stream().max((o1, o2) -> o2 - o1).get();
        System.out.println("Max : " + max);
        System.out.println("Min : " + min);

        List<Integer> duplicateNumbers = numbers.stream().filter(n -> Collections.frequency(numbers, n) > 1).distinct()
            .collect(Collectors.toList());
        System.out.println("Duplicate numbers : " + duplicateNumbers);

        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique numbers : " + uniqueNumbers);

        List<Integer> nonRepeatedNumbers = numbers.stream().filter(n -> Collections.frequency(numbers, n) <= 1)
            .collect(Collectors.toList());
        System.out.println("Non-repeated numbers : " + nonRepeatedNumbers);

        Map<String, Integer> prices = new HashMap<>();
        prices.put("iphone", 50000);
        prices.put("samsung", 35000);
        prices.put("pixel", 55000);
        prices.put("oneplus", 28000);
        LinkedHashMap<String, Integer> sortedMap = prices.entrySet().stream().sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Sorted Map : " + sortedMap);

        String name = "sai teja sangoju";
        Map<Character, Long> map = name.chars().mapToObj(c -> (char) c).filter(c -> c != ' ')
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println("Occurences of each character : " + map);

        List<String> fruits = Arrays.asList("apple", "banana", "apricot", "blueberry");
        Map<Character, List<String>> grouped = fruits.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("Grouped fruits : " + grouped);

        List<Integer> summarizingInt = Arrays.asList(1, 5, 3, 2, 6, 9, 8, 10);
        IntSummaryStatistics collect = summarizingInt.stream().collect(Collectors.summarizingInt(i -> i.intValue()));
        System.out.println("Avg : " + collect.getAverage());
        System.out.println("Count : " + collect.getCount());
        System.out.println("Max : " + collect.getMax());
        System.out.println("Min : " + collect.getMin());
        System.out.println("Sum : " + collect.getSum());

        List<String> names = Arrays.asList("sai", "teja", "sango");
        String joinedNames = names.stream().collect(Collectors.joining());
        String joinedNamesWithDelimiter = names.stream().collect(Collectors.joining(","));
        String joinedNamesWithDelimiterPrefixSuffix = names.stream().collect(Collectors.joining(",", "[ ", " ]"));
        System.out.println("joined names : " + joinedNames);
        System.out.println("joined names with delimiter : " + joinedNamesWithDelimiter);
        System.out.println("joined names with delimiter, prefix, suffix : " + joinedNamesWithDelimiterPrefixSuffix);

        List<Integer> nums = Arrays.asList(1, 1, 3, 3, 3, 2, 2, 4, 4, 4);
        int k = 3;
        List<Integer> kTimesRepeated = nums.stream().filter(n -> Collections.frequency(nums, n) >= k).distinct().toList();
        System.out.println("k times repeated numbers: " + kTimesRepeated);

        List<Integer> kTimesRepeatedByGroupingBy = new ArrayList<>();
        nums.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet().stream().filter(i -> i.getValue() >= k)
            .forEach(n -> kTimesRepeatedByGroupingBy.add(n.getKey()));
        System.out.println("k times repeated using Collectors,groupingBy() : " + kTimesRepeatedByGroupingBy);

    }

}
