package insert;

import insert.bst.BstUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //insertKeyDemo();
        searchKeyDemo();
    }

    private static void searchKeyDemo() {
        BstUtils bstUtils = new BstUtils();
        bstUtils.insert(30);
        bstUtils.insert(50);
        bstUtils.insert(20);
        bstUtils.insert(65);
        bstUtils.insert(5);
        bstUtils.printInOrder();
        System.out.println("Enter key to be searched in above bst");
        Scanner scanner = new Scanner(System.in);
        int keyToBeFound = scanner.nextInt();
        System.out.println("Searching " + keyToBeFound);
        System.out.println("Key found: " + bstUtils.searchKey(keyToBeFound));
    }

    private static void insertKeyDemo() {
        BstUtils bstUtils = new BstUtils();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of input you would like to give");
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            int value = scanner.nextInt();
            bstUtils.insert(value);
        }
        bstUtils.printPreOrder();
        bstUtils.printInOrder();
        bstUtils.printPostOrder();
    }
}
