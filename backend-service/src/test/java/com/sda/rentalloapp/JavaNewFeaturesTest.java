package com.sda.rentalloapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class JavaNewFeaturesTest {
@Test
    public void multilineString() {
        String meWithAddressOldWay =
                "Maciej       " +
                "Pulawy       ";


    String meWithAddressNewWay =
                """
                Maciej
                Pulawy                      
                """;

    String me = "Maciej";
    String me2= "Maciej";

    Assertions.assertEquals(me, me2);
    Assertions.assertSame(me, me2);
}

    @Test
    public void streamTest() {
        Stream.of("Ala", " ", "ma", " ", "kota")
                .map(s -> {
                    System.out.println("Mapping string: [%s]".formatted(s));
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("Filtered string: [%s]".formatted(s));
                    return s.length() > 2;
                })
                .toList();
    }
}
