package Binary_tree.Conclusion;

import interview_questions.trees.TreeNode;

public class Construct_binary_tree_from_inorder_and_postorder_traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if (inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int leftSize = 0;
        int rootIndex = 0;
        for (int i = inStart; i < (inEnd + 1); i++){
            if (inorder[i] == rootVal){
                rootIndex = i;
                leftSize = i - inStart;
            }
        }
        // The inStart and rootIndex-1 parameters specify the range of indices in the inorder array that correspond to the left subtree.
        // We know the size of the left subtree is leftSize = rootIndex - inStart, so we can compute the range of indices in the postorder array
        //  that correspond to the left subtree as postStart to postStart + leftSize - 1.
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        // The rootIndex+1 and inEnd parameters specify the range of indices in the inorder array that correspond to the right subtree.
        // We know the size of the right subtree is rightSize = inEnd - rootIndex, so we can compute the range of indices in the postorder array
        //  that correspond to the right subtree as postStart + leftSize to postEnd - 1.
        root.right = buildTree(inorder, postorder, inStart + leftSize + 1, inEnd, postStart + leftSize, postEnd - 1);
        return root;
    }
}
