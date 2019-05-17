package varun.problemsolving.string;

public class StringDivisor {
    public static void main(String[] args) {
        int a = findSmallestDivisor("rbrbbrn", "rbrbrn");
        System.out.println("Result: " + a);
    }

    public static int findSmallestDivisor(String s, String t) {



        // Write your code here
        if (s.equals(t)) {
            return s.length();
        }

        int fLength = s.length();
        int tLength = t.length();
        int diffLength = fLength - tLength;

        for (int i = 0; i < diffLength; i++) {
            if (s.substring(i).length() >= diffLength)
                if (t.equals(s.substring(i, i + diffLength))) {
                    return s.length() / diffLength;
                }
        }

        return -1;
    }
}
