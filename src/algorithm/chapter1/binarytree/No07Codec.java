package algorithm.chapter1.binarytree;

/**
 * @author YangShaw
 * @date 2021/3/20 11:53
 */
public class No07Codec {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private static final String NULL = "#";
    private static final String SEG = ",";
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL);
            sb.append(SEG);
            return;
        }
        sb.append(root.val + SEG);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    int index = -1;
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SEG);
        return solve(nodes);
    }

    public TreeNode solve(String[] nodes) {
        index++;
        if (nodes[index].equals(NULL)) {
            return null;
        }
        TreeNode current = new TreeNode(Integer.valueOf(nodes[index]));
        current.left = solve(nodes);
        current.right = solve(nodes);
        return current;
    }
}
