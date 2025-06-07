package com.hybridframework.utils;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionUtil {
	
	private static SoftAssert softAssert = new SoftAssert();

    // ----------------- HARD ASSERTIONS -----------------

    public static void hardAssertEquals(String actual, String expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            throw new AssertionError(message + " | Expected: " + expected + ", but got: " + actual, e);
        }
    }

    public static void hardAssertNotEquals(String actual, String expected, String message) {
        try {
            Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            throw new AssertionError(message + " | Both values matched unexpectedly: " + actual, e);
        }
    }

    public static void hardAssertTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
        } catch (AssertionError e) {
            throw new AssertionError(message + " | Condition was false.", e);
        }
    }

    public static void hardAssertFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
        } catch (AssertionError e) {
            throw new AssertionError(message + " | Condition was true.", e);
        }
    }

    public static void hardAssertNotNull(Object object, String message) {
        try {
            Assert.assertNotNull(object, message);
        } catch (AssertionError e) {
            throw new AssertionError(message + " | Object was null.", e);
        }
    }

    public static void hardAssertNull(Object object, String message) {
        try {
            Assert.assertNull(object, message);
        } catch (AssertionError e) {
            throw new AssertionError(message + " | Object was not null: " + object, e);
        }
    }

    // ----------------- SOFT ASSERTIONS -----------------

    public static void softAssertEquals(String actual, String expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public static void softAssertNotEquals(String actual, String expected, String message) {
        softAssert.assertNotEquals(actual, expected, message);
    }

    public static void softAssertTrue(boolean condition, String message) {
        softAssert.assertTrue(condition, message);
    }

    public static void softAssertFalse(boolean condition, String message) {
        softAssert.assertFalse(condition, message);
    }

    public static void softAssertNotNull(Object object, String message) {
        softAssert.assertNotNull(object, message);
    }

    public static void softAssertNull(Object object, String message) {
        softAssert.assertNull(object, message);
    }

    public static void softAssertAll() {
        softAssert.assertAll();
    }

    public static void resetSoftAssert() {
        softAssert = new SoftAssert(); // Re-initialize to avoid carry-over
    }

}
