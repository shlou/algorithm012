import java.util.LinkedList;
import java.util.List;

public class Node {

    public int val;
    public List<Node> children;
    public Node () {}
    public Node (int _val) { val = _val; children = new LinkedList<>(); }
    public Node (int _val, List<Node> _children) { val = _val; children = _children; }

    public final Node getTestCase () {
        Node n6 = new Node(6);
        Node n5 = new Node(5);
        List<Node> n3c = new LinkedList<>();
        n3c.add(n5);
        n3c.add(n6);
        Node n3 = new Node(3, n3c);
        Node n2 = new Node(2);
        Node n4 = new Node(4); 
        List<Node> n1c = new LinkedList<>();
        n1c.add(n3);
        n1c.add(n2);
        n1c.add(n4);
        Node n1 = new Node(1, n1c);
        return n1;
    }

}