package trees.bst;

import trees.bst.BstUtils;

import java.util.Scanner;

public class BstFunctions {

    public static void main(String[] args) {
        insertKeyDemo();
        //searchKeyDemo();
        //modifyBstDemo();
        //searchlowestDemo();
    }

    private static void searchKeyDemo() {
        BstUtils bstUtils = new BstUtils();
        insertDummyData(bstUtils);
        System.out.println("Enter key to be searched in above bst");
        Scanner scanner = new Scanner(System.in);
        int keyToBeFound = scanner.nextInt();
        System.out.println("Searching " + keyToBeFound);
        System.out.println("Key found: " + bstUtils.searchKey(keyToBeFound));
    }

    private static void insertDummyData(BstUtils bstUtils) {
        bstUtils.insert(30);
        bstUtils.insert(50);
        bstUtils.insert(20);
        bstUtils.insert(65);
        bstUtils.insert(5);
        bstUtils.printInOrder();
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

    private static void modifyBstDemo() {
        BstUtils bstUtils = new BstUtils();
        insertDummyData(bstUtils);
        bstUtils.modifyBst();
    }

    private static void searchlowestDemo() {
        BstUtils bstUtils = new BstUtils();
        insertDummyData(bstUtils);
        System.out.println("Enter the lowest number to find");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        bstUtils.searchLowest(value-1);
    }
}
