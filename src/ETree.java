import java.io.*;
import java.util.Scanner;

public class ETree {
    TreeNode root;
    static int size;

    public ETree (TreeNode r) {
        root = r;
        size++;
    }
    public ETree () {
        this(new TreeNode());
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    public TreeNode getRoot() {
        return root;
    }

    public TreeNode buildTree() throws IOException {
        //Scanner sn = new Scanner(System.in);
        //System.out.print("Enter filename: ");
        //String file = sn.nextLine();
        //File ifile = new File(file);
        //Scanner read = new Scanner(ifile);
        Scanner read = new Scanner(System.in);
        System.out.print("Enter an equation with parenthesis: ");

        String[] line = read.nextLine().split(" ");

        ETree bt = new ETree();
        TreeNode current = root;

        for (String s : line) {
            String[] arr = s.split("[(]");
            for (int i = 0; i < arr.length; i++) {
                switch (arr[i]) {
                    case "":
                        TreeNode newest = new TreeNode();
                        if (current.leftIsEmpty()) {
                            current.setLeft(newest);
                            current = current.getLeft();
                        } else if (current.rightIsEmpty()) {
                            current.setRight(newest);
                            current = current.getRight();
                        }
                        break;
                    case "+", "-", "/", "*":
                        while (current.getParent().getValue() != null) {
                            current = current.getParent();
                        }
                        current = current.getParent();
                        current.setValue(arr[i]);
                        break;
                    default:
                        String arr2[] = arr[i].split("[)]");
                        TreeNode newest2 = new TreeNode();
                        if (i > 0) {
                            if (current.leftIsEmpty()) {
                                newest2.setValue(arr[i]);
                                current.setLeft(newest2);
                                current = current.getLeft();
                            } else if (current.rightIsEmpty()) {
                                newest2.setValue(arr[i]);
                                current.setRight(newest2);
                                current = current.getRight();
                            }
                        } else {
                            if (current.leftIsEmpty()) {
                                newest2.setValue(String.valueOf(arr2[0]));
                                current.setLeft(newest2);
                            } else if (current.rightIsEmpty()) {
                                newest2.setValue(String.valueOf(arr2[0]));
                                current.setRight(newest2);
                            }
                        }
                }
            }
        }
        return getRoot();
    }

    public void preOrderTrav(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.getValue() + ", ");
        preOrderTrav(node.getLeft());
        preOrderTrav(node.getRight());
    }
    public void inOrderTrav(TreeNode node) {
        if (node == null)
            return;
        inOrderTrav(node.getLeft());
        System.out.print(node.getValue() + ", ");
        inOrderTrav(node.getRight());
    }
    public void postOrderTrav(TreeNode node) {
        if (node == null)
            return;
        postOrderTrav(node.getLeft());
        postOrderTrav(node.getRight());
        System.out.print(node.getValue() + ", ");
    }
}
