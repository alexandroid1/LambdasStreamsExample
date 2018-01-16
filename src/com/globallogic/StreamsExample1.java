package com.globallogic;

import com.globallogic.POJO.Person;
import com.globallogic.POJO.Track;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.stream.Collectors.toList;

public class StreamsExample1 {

    public static void main(String[] args) {


        // ----- count(); -----

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

        // --- flatMap ---
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        System.out.println(together); // 1, 2, 3, 4

        // --- max & min ---
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        //example with for
        Track shortestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLenght() < shortestTrack.getLenght()) { shortestTrack = track;
            } }

        System.out.println(shortestTrack); // "Violets for Your Furs", 378

        //example with lambda
        Track shortestTrack1 = tracks.stream()
                .min(Comparator.comparing(track -> track.getLenght()))
                .get();

        System.out.println(shortestTrack1); // "Violets for Your Furs", 378

        // --- reduce ---
        int sum = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);

        System.out.println(sum); // 6

    }
}
