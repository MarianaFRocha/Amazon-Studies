import java.util.Scanner;

class Solution {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */



    public static int numberOfNodes(Node root) {

        if (root == null) {
            return 0;
        } else {
            return numberOfNodes(root.left) + numberOfNodes(root.right) + 1;
        }
    }

    public static int heightMax(Node root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }


    public static int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }



/*    public static int height(int t) {
        return (int)(Math.log(t) / Math.log(2));
    }*/

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}