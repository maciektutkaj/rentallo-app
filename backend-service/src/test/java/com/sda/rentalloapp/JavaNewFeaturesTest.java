package com.sda.rentalloapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
