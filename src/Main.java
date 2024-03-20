import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sn = new Scanner(System.in);
        ETree t = new ETree();
        t.buildTree();
        System.out.println();

        System.out.print("PreOrder Traversal: ");
        t.preOrderTrav(t.root);
        System.out.println();
        System.out.print("InOrder Traversal: ");
        t.inOrderTrav(t.root);
        System.out.println();
        System.out.print("PostOrder Traversal: ");
        t.postOrderTrav(t.root);
        System.out.println();
        System.out.println();

        System.out.println("Would you like to change the numbers in this tree?");
        System.out.println("Enter \"y\" to continue or any other button to exit: ");
        String answer = sn.nextLine();
        try {
            if (answer.charAt(0) == 'y') {
                System.out.println("you entered \"y\"");
            }
        }
        catch (Exception e) {
            System.out.println("Goodbye");
        }
    }
}