public class Node {

    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "\nNode{" +
                "\n   left=" + left +
                "\n  right=" + right +
                "\n  data=" + data +
                '}';
    }
}
