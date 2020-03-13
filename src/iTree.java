public class iTree {

    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int d) {
            this.value = d;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public iTree() {
        this.root = null;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public Node getRoot() {
        return this.root;
    }

    public static void main(String[] args) {

        iTree bt = new iTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
//        bt.add(3);
//        bt.add(5);
//        bt.add(7);
//        bt.add(9);

        Node head = bt.getRoot();

        //rec(head);
        gain(head);
        System.out.print(max);
    }

    public static void rec(Node root) {

    }

    static int max;

    public static int gain(Node node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(gain(node.left), 0);
        int right = Math.max(gain(node.right), 0);

        int path = node.value + left + right;
        if (path > max) {
            max = path;
        }

        return node.value + Math.max(left, right);
    }
}
