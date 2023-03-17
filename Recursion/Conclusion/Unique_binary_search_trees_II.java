package Recursion.Conclusion;


import java.util.ArrayList;
import java.util.List;

import interview_questions.trees.TreeNode;

// The generateTrees() function creates a list trees to store all the possible BSTs that can be constructed from the range of values.
// If start is greater than end, it adds a null to the list of trees since this represents an empty tree.
// The function then iterates from start to end, and for each value i it generates all the possible left and right subtrees using recursion.
// It then combines all the possible combinations of left and right subtrees with the current value i as the root to generate all possible BSTs for the current range of values.
// These trees are added to the trees list.
public class Unique_binary_search_trees_II {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return null;
        }
        return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> trees = new ArrayList<>();
        if (start > end){
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++){
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees){
                for (TreeNode right : rightTrees){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    trees.add(node);
                }
            }
        }
        return trees;
    }
}
