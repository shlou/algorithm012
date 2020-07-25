import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class TreeNodeSerializer implements Debugger {

    public void run () {}

    // solution #1
    // DFS
    class Codec {
        public String serialize(final TreeNode root) {
            return rserialize(root, "");
        }

        private String rserialize(final TreeNode root, String str) {
            if (root == null)
                str += "None,";
            else {
                str += str.valueOf(root.val) + ",";
                str = rserialize(root.left, str);
                str = rserialize(root.right, str);
            }
            return str;
        }

        public TreeNode deserialize(final String data) {
            final String[] data_array = data.split(",");
            List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
            return rdeserialize(data_list);
        }

        private TreeNode rdeserialize(List<String> l) {
            if (l.get(0).equals("None")) {
                l.remove(0);
                return null;
            }

            final TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
             l.remove(0);
             root.left = rdeserialize(l);
             root.right = rdeserialize(l);
             return root;
        }
    }
    
    // solution #2
    // encode/decode todo.
}