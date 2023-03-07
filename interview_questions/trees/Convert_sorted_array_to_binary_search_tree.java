package interview_questions.trees;

public class Convert_sorted_array_to_binary_search_tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0){
            return null;
        }
        return generateTree(nums, 0, length - 1);
    }
    private TreeNode generateTree(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        // Find the middle of the range given to identify the node
        //  and continue to generate the rest of tree by dividing the range into the left one (left, middle - 1) and the right one (middle + 1, right)
        //  iterating those steps till the left > right means the range is invalid
        int middle = (left + right)/2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = generateTree(nums, left, middle - 1);
        node.right = generateTree(nums, middle + 1, right);
        return node;
    }
}
