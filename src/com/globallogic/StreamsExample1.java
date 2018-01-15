package com.globallogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.stream.Collectors.toList;

public class StreamsExample1 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        /*people.stream()
                .filter(p -> p.getLastName().startsWith("C"))
                .forEach( p -> System.out.println(p.getFirstName()));*/

        //Stream<Person> stream = people.stream();

        //using parallelStream
        long count = people.parallelStream()
                .filter(p -> p.getLastName().startsWith("D"))
                .count();
        System.out.println(count);

        //---  collect(toList()) ---

        // example 1
        List<String> collected = Stream.of("a", "b", "c")
                .collect(toList());
        System.out.println(collected); // "a", "b", "c"

        // example 2
        List<String> collected1 = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(toList());
        System.out.println(collected1); // "A", "B", "HELLO"

        // example 3
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(toList());
        System.out.println(beginningWithNumbers); // 1abc

    }
}
