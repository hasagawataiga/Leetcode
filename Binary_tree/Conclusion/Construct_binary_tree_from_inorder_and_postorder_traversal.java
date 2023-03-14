package Binary_tree.Conclusion;

import java.util.HashMap;

import interview_questions.trees.TreeNode;

public class Construct_binary_tree_from_inorder_and_postorder_traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }
    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer, Integer> map){
        if (inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inStart;
        // The inStart and rootIndex-1 parameters specify the range of indices in the inorder array that correspond to the left subtree.
        // We know the size of the left subtree is leftSize = rootIndex - inStart, so we can compute the range of indices in the postorder array
        //  that correspond to the left subtree as postStart to postStart + leftSize - 1.
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1, map);
        // The rootIndex+1 and inEnd parameters specify the range of indices in the inorder array that correspond to the right subtree.
        // We know the size of the right subtree is rightSize = inEnd - rootIndex, so we can compute the range of indices in the postorder array
        //  that correspond to the right subtree as postStart + leftSize to postEnd - 1.
        root.right = buildTree(inorder, postorder, inStart + leftSize + 1, inEnd, postStart + leftSize, postEnd - 1, map);
        return root;
    }
}
