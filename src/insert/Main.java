package insert;

import insert.bst.InsertUtil;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InsertUtil insertUtil = new InsertUtil();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of input you would like to give");
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            int value = scanner.nextInt();
            insertUtil.insert(value);
        }
        insertUtil.printPreOrder();
        insertUtil.printInOrder();
        insertUtil.printPostOrder();
    }
}
