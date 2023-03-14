package Binary_tree.Conclusion;

import java.util.HashMap;

import interview_questions.trees.TreeNode;

public class Construct_bianry_tree_from_inorder_and_preorder_traversals {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store the value of preorder into a hashmap for efficiently access later in the recursion
        //  instead of access directly in array, because we have to check every elements inside the array to get the root value.
        //  In that case, using HashMap is more convinience than array
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> map){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        int leftSize = index - inStart;
        // Example: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //  the root is the first element of preorder
        //  find the root inside the inorder
        //  inorder will be splited into 2 parts: left node and right node
        //  left node from inStart -> index - 1
        //      while the preorder for the left node is from: preStart + 1 -> preStart + leftSize
        //  right node from index + 1 -> inEnd
        //      while the preorder for the right node is from: preStart + leftSize + 1 -> preEnd
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftSize, inStart, index - 1, map);
        root.right = buildTree(preorder, inorder, preStart + leftSize + 1, preEnd, index + 1, inEnd, map);
        return root;
    }
}
