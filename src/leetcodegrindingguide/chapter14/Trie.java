package leetcodegrindingguide.chapter14;

public class Trie {

    class TreeNode {
        boolean exist = false;
        TreeNode[] children = new TreeNode[26];
    }

    TreeNode root = null;
    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        char[] array = word.toCharArray();
        TreeNode cur = root;
        for (char c: array) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TreeNode();
            }
            cur = cur.children[index];
        }
        cur.exist = true;
    }

    public boolean search(String word) {
        char[] array = word.toCharArray();
        TreeNode cur = root;
        for (char c : array) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }

        return cur.exist;
    }

    public boolean startsWith(String prefix) {
        char[] array = prefix.toCharArray();
        TreeNode cur = root;
        for (char c : array) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}
