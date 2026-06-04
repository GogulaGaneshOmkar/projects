import java.util.Scanner;

// TreeNode Class
class TreeNode {

    int data;
    TreeNode left, right;

    // Constructor
    TreeNode(int value) 
    {
        data = value;
        left = right = null;
    }
}

// Binary Search Tree Class
class BinarySearchTree 
{

    TreeNode root;

    // Insert Node
    TreeNode insert(TreeNode root, int value) 
    {

        if (root == null)
        {
            return new TreeNode(value);
        }

        if (value < root.data) 
        {
            root.left = insert(root.left, value);
        }
        else if (value > root.data) 
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Search Node
    boolean search(TreeNode root, int key) 
    {

        if (root == null) 
        {
            return false;
        }

        if (root.data == key) 
        {
            return true;
        }

        if (key < root.data) 
        {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Find Minimum Value
    TreeNode findMin(TreeNode root) 
    {

        while (root.left != null) 
        {
            root = root.left;
        }

        return root;
    }

    // Delete Node
    TreeNode delete(TreeNode root, int value) 
    {

        if (root == null) 
        {
            return null;
        }

        if (value < root.data) 
        {
            root.left = delete(root.left, value);
        }
        else if (value > root.data)
            {
            root.right = delete(root.right, value);
        }
        else
        {

            // Node with one child or no child
            if (root.left == null) 
            {
                return root.right;
            }
            else if (root.right == null) 
            {
                return root.left;
            }

            // Node with two children
            TreeNode minNode = findMin(root.right);

            root.data = minNode.data;

            root.right = delete(root.right, minNode.data);
        }

        return root;
    }

    // In-Order Traversal
    void inorder(TreeNode root) 
    {

        if (root != null) 
        {

            inorder(root.left);

            System.out.print(root.data + " ");

            inorder(root.right);
        }
    }

    // Pre-Order Traversal
    void preorder(TreeNode root) 
    {

        if (root != null) 
        {

            System.out.print(root.data + " ");

            preorder(root.left);

            preorder(root.right);
        }
    }

    // Post-Order Traversal
    void postorder(TreeNode root) 
    {

        if (root != null) 
        {

            postorder(root.left);

            postorder(root.right);

            System.out.print(root.data + " ");
        }
    }
}

public class BSTImplementation 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        BinarySearchTree bst = new BinarySearchTree();

        int choice, value;

        do 
        {

            System.out.println("\n===== BINARY SEARCH TREE =====");
            System.out.println("1. Insert Node");
            System.out.println("2. Delete Node");
            System.out.println("3. Search Node");
            System.out.println("4. In-Order Traversal");
            System.out.println("5. Pre-Order Traversal");
            System.out.println("6. Post-Order Traversal");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {

                // Insert
                case 1:

                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();

                    bst.root = bst.insert(bst.root, value);

                    System.out.println("Node Inserted Successfully!");
                    break;

                // Delete
                case 2:

                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();

                    bst.root = bst.delete(bst.root, value);

                    System.out.println("Node Deleted Successfully!");
                    break;

                // Search
                case 3:

                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();

                    if (bst.search(bst.root, value)) 
                    {
                        System.out.println("Node Found!");
                    }
                    else 
                    {
                        System.out.println("Node Not Found!");
                    }

                    break;

                // Inorder
                case 4:

                    System.out.print("In-Order Traversal: ");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;

                // Preorder
                case 5:

                    System.out.print("Pre-Order Traversal: ");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;

                // Postorder
                case 6:

                    System.out.print("Post-Order Traversal: ");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;

                // Exit
                case 7:

                    System.out.println("Program Exited.");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
