package varun.dsa.algoexpert.medium;

import varun.Utils;

import java.util.ArrayList;

/**
 * Valid IP Addresses
 * You're given a string of length 12 or smaller, containing only digits. Write a function that returns all the
 * possible IP addresses that can be created by inserting three . s in the string.
 * An IP address is a sequence of four positive integers that are separated by . s, where each individual integer is
 * within the range 0 - 255 , inclusive.
 * An IP address isn't valid if any of the individual integers contains leading Os.
 * For example, "192.168.0.1" is a valid IP address, but
 * 192.168.00.1" and "192.168.0.01" aren't, because they contain "00" and 01 , respectively.
 * Another example of a valid IP address is "99.1.1.10" ; conversely, "991.1.1.0" isn't valid, because "991" is > 255.
 * Your function should return the IP addresses in string format and in no particular order. If no valid IP addresses
 * can be created from the string, your function should return an empty list.
 * <p>
 * Note: check out our Systems Design Fundamentals on SystemsExpert to learn more about IP addresses!
 * <p>
 * Sample Input
 * string = "1921680"
 * Sample Output
 * "1.9.216.80",
 * "1.92.16.80",
 * "1.92.168.0"
 * "19.2.16.80",
 * "19.2.168.0",
 * "19.21.6.80",
 * "19.21.68.0",
 * "19.216.8.0",
 * "192.1.6.80",
 * "192.1.68.0",
 * "192.16.8.0"
 * //The IP addresses could be ordered differently.
 * <p>
 * Complexity:
 * Time Complexity: O(1) as in total there can be only 2^32 IP valid addresses. 2^32 is a constant and hence it's O(1)
 * Space Complexity: O(1) same reason as above.
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Valid%20IP%20Addresses
 */
public class ValidIPAddresses {

    public static void main(String[] args) {
        String input = "1921680";
        System.out.println("<-- Input -->");
        System.out.println("Number: " + input);
        String[] output = findValidIpAddresses(input);
        System.out.println("<-- Output -->");
        Utils.print(output);
    }

    private static String[] findValidIpAddresses(String input) {
        ArrayList<String> output = new ArrayList<>();

        for (int i = 1; i < Math.min((int) input.length(), 4); i++) {
            String[] ipAddresses = new String[]{"", "", "", ""};

            ipAddresses[0] = input.substring(0, i);
            if (!isValidPart(ipAddresses[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min((int) input.length() - i, 4); j++) {
                ipAddresses[1] = input.substring(i, j);
                if (!isValidPart(ipAddresses[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min((int) input.length() - j, 4); k++) {
                    ipAddresses[2] = input.substring(j, k);
                    ipAddresses[3] = input.substring(k);

                    if (isValidPart(ipAddresses[2]) && isValidPart(ipAddresses[3])) {
                        output.add(join(ipAddresses));
                    }
                }
            }
        }
        return output.toArray(new String[0]);
    }

    private static boolean isValidPart(String string) {
        int value = Integer.parseInt(string);
        if (value > 255) {
            return false;
        }
        return string.length() == Integer.toString(value).length(); //avoiding trailing zeroes.
    }

    private static String join(String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
            if (i < strings.length - 1) {
                builder.append(".");
            }
        }
        return builder.toString();
    }
}
