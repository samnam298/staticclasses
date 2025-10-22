package com.pluralsight;

public class NameFormatter {
    // ✅ Private constructor to prevent object creation
    private NameFormatter() {}

    // Method 1: first + last
    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }