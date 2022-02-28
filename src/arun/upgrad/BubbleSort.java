package arun.upgrad;

import java.util.Scanner;

public class BubbleSort {
    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter product type String : ");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println(getStringOrderId(string));
    }

    public static String getStringOrderId(String randomNumber) {
        char[] charArray = randomNumber.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        StringBuilder orderIdBuilder = new StringBuilder();
        while (left <= right) {
            int value;
            int value1 = Integer.parseInt(String.valueOf(charArray[left]));
            if (left == right) {
                value = value1;
            } else {
                value = value1 + Integer.parseInt(String.valueOf(charArray[right]));
            }
            orderIdBuilder.append(value);
            left++;
            right--;
        }
        return orderIdBuilder.toString();
    }

    public static String getTag(String productType) {
        char[] charArray = productType.toCharArray();
        StringBuilder tagBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char character1 = charArray[i];
            if (i == charArray.length - 1) {
                tagBuilder.append(character1);
                break;
            }

            int value1 = character1;
            char character2 = charArray[i + 1];
            int value2 = character2;
            if (value1 > value2) {
                tagBuilder.append(character1);
            } else {
                tagBuilder.append(character2);
            }
        }
        return tagBuilder.toString();
    }

}