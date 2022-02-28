package arun.upgrad;

public class Duplicates {
    public static void main(String[] args) {
        findDuplicates(new int[]{1, 2, 3, 4, 1, 4});
        findDuplicates1(new int[]{1, 2, 3, 4, 1, 4});
    }

    public static void findDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println("Duplicate found: " +  array[i]);
                    break;
                }
            }
        }
    }

    public static void findDuplicates1(int[] array) {
        System.out.println("Duplicate data: ");
        int count[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
            if (count[array[i]] == 2) {
                System.out.print(" " + array[i]);
            }
        }
    }
}
