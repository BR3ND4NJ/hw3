public class TreeNode {
    String value;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode (String e, TreeNode p, TreeNode l, TreeNode r) {
        value = e;
        parent = p;
        left = l;
        right = r;
    }
    public TreeNode (String e) {
        this (e, null, null, null);
    }
    public TreeNode () {
        this("0", null, null, null);
    }

    public void setValue(String value) {
        this.value = value;
    }
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }
    public void setRight(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public String getValue() {
        return value;
    }
    public TreeNode getParent() {
        return parent;
    }
    public TreeNode getLeft() {
        return left;
    }
    public TreeNode getRight() {
        return right;
    }

    public boolean parentIsEmpty() {
        return getParent() == null;
    }
    public boolean leftIsEmpty() {
        return getLeft() == null;
    }
    public boolean rightIsEmpty() {
        return getRight() == null;
    }

}
