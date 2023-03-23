package Leetcode_75.Tree;

import java.util.ArrayList;
import java.util.List;


public class N_ary_tree_preorder_traversal {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null){
            return res;
        }
        res.add(root.val);
        if (root.children == null){
            return res;
        }
        int size = root.children.size();
        int index = 0;
        while (index < size){
            preorder(root.children.get(index));
            index++;
        }
        return res;
    }
}
