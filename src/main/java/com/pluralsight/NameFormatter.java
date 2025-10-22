package com.pluralsight;

public class NameFormatter {
    private NameFormatter() {}


    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder formattedName = new StringBuilder();
        // LastName always required
        formattedName.append(lastName);

        // Prefix and others are optional
        if (prefix != null && !prefix.isBlank()) {
            formattedName.append(", ").append(prefix);
        }

        formattedName.append(" ").append(firstName);

        if (middleName != null && !middleName.isBlank()) {
            formattedName.append(" ").append(middleName);
        }

        if (suffix != null && !suffix.isBlank()) {
            formattedName.append(", ").append(suffix);
        }

        return formattedName.toString().trim();
    }

    // Method 3: fullName input (already formatted as "Prefix First Middle Last, Suffix")
    public static String format(String fullName) {
        // Split at comma if suffix exists
        String suffix = "";
        String mainPart = fullName;
        if (fullName.contains(",")) {
            String[] parts = fullName.split(",");
            mainPart = parts[0].trim();
            suffix = parts[1].trim();
        }

        // Split remaining parts
        String[] words = mainPart.split(" ");
        String prefix = "", firstName = "", middleName = "", lastName = "";

        // Prefix detection
        if (words[0].endsWith(".")) {
            prefix = words[0];
            firstName = words[1];
            if (words.length == 4) {
                middleName = words[2];
                lastName = words[3];
            } else {
                lastName = words[2];
            }
        } else {
            firstName = words[0];
            if (words.length == 3) {
                middleName = words[1];
                lastName = words[2];
            } else {
                lastName = words[1];
            }
        }

        // Reuse our second method for formatting
        return format(prefix, firstName, middleName, lastName, suffix);
    }
}