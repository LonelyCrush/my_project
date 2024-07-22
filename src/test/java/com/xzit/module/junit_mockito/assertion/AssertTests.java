package com.xzit.module.junit_mockito.assertion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.CombinableMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.startsWith;

public class AssertTests {

    @Test
    public void testArrayEquals() {
        byte[] byteArray1 = "abc".getBytes(StandardCharsets.UTF_8);
        byte[] byteArray2 = "abc".getBytes(StandardCharsets.UTF_8);
        Assertions.assertArrayEquals(byteArray1, byteArray2, "failure - byte arrays not same");
    }

    @Test
    public void testAssertEquals() {
        Assertions.assertEquals("abc", "abc", "failure - strings not same");
    }

    @Test
    public void testAssertFalse() {
        Assertions.assertFalse(false, "failure - should be false");
    }

    @Test
    public void testAssertNotNull() {
        Assertions.assertNotNull(new Object(), "should not be null");
    }

    @Test
    public void testAssertNotSame() {
        Assertions.assertNotSame(new Object(), new Object(), "should not be same Object");
    }

    @Test
    public void testAssertNull() {
        Assertions.assertNull(null, "should be null");
    }

    @Test
    public void testAssertSame() {
        Integer aNumber = 768;
        Assertions.assertSame(aNumber, aNumber, "should be same");
    }

    // JUnit Matchers assertThat
    @Test
    public void testAssertThatBothContainsString() {
        MatcherAssert.assertThat("albumen", both(containsString("a")).and(containsString("b")));
    }

    @Test
    public void testAssertThatHasItems() {
        MatcherAssert.assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }

    @Test
    public void testAssertThatEveryItemContainsString() {
        MatcherAssert.assertThat(Arrays.asList("fun", "ban", "net"), everyItem(containsString("n")));
    }

    // Core Hamcrest Matchers with assertThat
    @Test
    public void testAssertThatHamcrestCoreMatchers() {
        MatcherAssert.assertThat("good", allOf(equalTo("good"), startsWith("good")));
        MatcherAssert.assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        MatcherAssert.assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        MatcherAssert.assertThat(7, not(CombinableMatcher.either(equalTo(3)).or(equalTo(4))));
        MatcherAssert.assertThat(new Object(), not(sameInstance(new Object())));
    }

    @Test
    public void testAssertTrue() {
        Assertions.assertTrue(true, "failure - should be true");
    }
}
