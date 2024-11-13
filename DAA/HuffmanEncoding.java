import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Node {
    int freq;
    char symbol;
    Node left;
    Node right;
    String huffCode = "";

    public Node(int freq, char symbol) {
        this.freq = freq;
        this.symbol = symbol;
        this.left = null;
        this.right = null;
    }

    public Node(int freq, Node left, Node right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
        this.symbol = '-'; // Represents an internal node in the tree
    }

    // Recursive method to print Huffman codes for each character
    public void printCodes(String code) {
        String newCode = code + huffCode;

        if (left == null && right == null) {
            // Leaf node: print character and its code
            System.out.println(symbol + " -> " + newCode);
            return;
        }

        if (left != null) left.printCodes(newCode);
        if (right != null) right.printCodes(newCode);
    }
}

public class HuffmanEncoding {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {10, 4, 9, 7, 1, 15};
        List<Node> nodes = new ArrayList<>();

        // Creating a list of nodes for each character and its frequency
        for (int i = 0; i < chars.length; i++) {
            nodes.add(new Node(freq[i], chars[i]));
        }

        // Build Huffman Tree
        while (nodes.size() > 1) {
            // Sort nodes by frequency in ascending order
            nodes.sort(Comparator.comparingInt(node -> node.freq));

            // Take two nodes with the smallest frequencies
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            // Assign '0' and '1' to the left and right nodes
            left.huffCode = "0";
            right.huffCode = "1";

            // Create a new internal node with combined frequency
            Node newNode = new Node(left.freq + right.freq, left, right);

            // Remove the two nodes and add the new node to the list
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(newNode);
        }

        // Print the Huffman codes
        System.out.println("Characters: " + java.util.Arrays.toString(chars));
        System.out.println("Frequencies: " + java.util.Arrays.toString(freq));
        System.out.println("\nHuffman Encoding:");
        nodes.get(0).printCodes(""); // The root node of the Huffman Tree
    }
}
