public class BSTree {
    TreeNode root;
    public class BinarySearchTree {
        public BinarySearchTree() {
            root = null;
        }
    }

    public void printKeysInOrder() {
        printKeysInOrderRecursive(root);
    }

    private void printKeysInOrderRecursive(TreeNode node) {
        if (node != null) {
            printKeysInOrderRecursive(node.left);
            System.out.println(node.key);
            printKeysInOrderRecursive(node.right);
        }
    }


    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private TreeNode insertRecursive(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRecursive(root.left, key);
        else if (key > root.key)
            root.right = insertRecursive(root.right, key);

        return root;
    }

    public int findKthSmallest(int k) {
        return findKthSmallest(root, k);
    }

    private int findKthSmallest(TreeNode node, int k) {
        if (node == null)
            return -1; // Si el árbol está vacío o si la posición k es mayor que el número de nodos

        int leftSubtreeSize = size(node.left);

        if (k == leftSubtreeSize + 1)
            return node.key; // El nodo actual es el k-ésimo más pequeño

        if (k <= leftSubtreeSize)
            return findKthSmallest(node.left, k); // Buscar en el subárbol izquierdo

        return findKthSmallest(node.right, k - leftSubtreeSize - 1); // Buscar en el subárbol derecho
    }
    private int size(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public boolean find(int key) {
        return findRecursive(root, key);
    }

    private boolean findRecursive(TreeNode node, int key) {
        if (node == null) {
            return false; // El árbol está vacío o hemos llegado al final de un subárbol sin encontrar el valor
        }

        if (key == node.key) {
            return true; // Hemos encontrado el valor
        }

        if (key < node.key) {
            return findRecursive(node.left, key); // Buscar en el subárbol izquierdo
        } else {
            return findRecursive(node.right, key); // Buscar en el subárbol derecho
        }
    }

}
