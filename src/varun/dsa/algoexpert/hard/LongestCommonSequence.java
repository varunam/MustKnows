package varun.dsa.algoexpert.hard;

import varun.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [ALERT] - INCOMPLETE SOLUTION. DON'T STUDY
 */
public class LongestCommonSequence {

    public static void main(String[] args) {
        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";
        System.out.println("<--Input-->");
        System.out.println("String One: " + str1 + ", String two: " + str2);
        System.out.println("<--Output-->");
        List<Character> result = longestCommonSubsequence(str1, str2);
        Utils.print(result);
    }

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        List<Character> maxSubString = new ArrayList<>();
        List<Character> tempSub = new ArrayList<>();
        int lastFoundIndex = -1;
        boolean flag = false;
        for(int fCharIndex = 0; fCharIndex < str1.length(); fCharIndex++) {
            for(int sCharIndex = 0; sCharIndex < str2.length(); sCharIndex++) {
                if(str1.charAt(fCharIndex) != str2.charAt(sCharIndex)) {
                    continue;
                }
                if(sCharIndex > lastFoundIndex) {
                    lastFoundIndex = sCharIndex;
                    tempSub.add(str2.charAt(sCharIndex));
                    flag = true;
                    break;
                }
            }
            if(tempSub.size() > maxSubString.size()) {
                maxSubString = tempSub;
                lastFoundIndex = -1;
                if(!flag) {
                    tempSub.clear();
                    flag = false;
                }
            }
        }
        return maxSubString;
    }
}
