package com.pluralsight;

public class NameFormatter {
    private NameFormatter() {}


    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder formattedName = new StringBuilder();