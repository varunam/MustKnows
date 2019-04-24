package problemsolving.string;

public class CheckPermutationOfEachOther {

    public static void main(String[] args) {
        String a = "ThisIsASampleString";
        String b = "IsThisASampleString";

        System.out.println("Permutation of each other: " + isPermutationOfEachOther(a, b));
    }

    private static boolean isPermutationOfEachOther(String a, String b) {
        int total1 = 0;
        int total2 = 0;
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            total1 = total1 + (int) a.charAt(i);
            total2 = total2 + (int) b.charAt(i);
        }

        return total1 == total2;
    }
}
