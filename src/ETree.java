import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ETree {
    TreeNode root;
    static int size;

    public ETree (TreeNode r) {
        root = r;
        size = 1;
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

    public void buildTree() throws IOException {
        //Scanner sn = new Scanner(System.in);
        //System.out.print("Enter filename: ");
        //String file = sn.nextLine();
        //File ifile = new File(file);
        File ifile = new File("test.txt"); //Delete when done testing
        Scanner read = new Scanner(ifile);

        String line;

        ETree bt = new ETree();
        TreeNode current = bt.root;

        while (read.hasNext()) {
            line = read.next();
            System.out.println("LINE: " + line);
            String[] arr = line.split("[(]");
            for (int i = 0; i < arr.length; i++) {
                switch (arr[i]) {
                    case "":
                        TreeNode newest = new TreeNode();
                        if (current.leftIsEmpty()) {
                            current.setLeft(newest);
                            current = current.getLeft();
                        }
                        else if (current.rightIsEmpty()) {
                            current.setRight(newest);
                            current = current.getRight();
                        }
                        break;
                    case "+", "-", "/", "*":
                        TreeNode newest2 = new TreeNode();
                        newest2.setValue(arr[i]);
                        current.setParent(newest2);
                        current = current.getParent();
                        break;
                    default:
                        String arr2[] = arr[i].split("[)]");
                        TreeNode newest3 = new TreeNode();
                        if (i > 0) {
                            if (current.leftIsEmpty()) {
                                if (arr[i - 1].equals(" ")) {
                                    newest3.setValue(arr[i]);
                                    current.setLeft(newest3);
                                    current = current.getLeft();
                                } else {
                                    current.setValue(arr[i]);
                                }
                            }
                            else if (current.rightIsEmpty()) {
                                if (arr[i - 1].equals(" ")) {
                                    newest3.setValue(arr[i]);
                                    current.setLeft(newest3);
                                    current = current.getLeft();
                                } else {
                                    current.setValue(arr[i]);
                                }
                            }
                        }
                        if (current.leftIsEmpty()) {
                            newest3.setValue(String.valueOf(arr2[0]));
                        }
                        else if (current.rightIsEmpty()) {
                            newest3.setValue(String.valueOf(arr2[0]));
                        }
                }
            }
            System.out.println();
        }
    }
}
