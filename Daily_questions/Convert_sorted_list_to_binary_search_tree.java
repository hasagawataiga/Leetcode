
import java.util.ArrayList;
import java.util.List;

import interview_questions.linked_list.ListNode;
import interview_questions.trees.TreeNode;

public class Convert_sorted_list_to_binary_search_tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return listToBST(list, 0, list.size());
    }
    private TreeNode listToBST(List<Integer> list, int left, int right){
        if (left == right){
            return null;
        }
        int middle = left + (right - left)/2;
        TreeNode node = new TreeNode(list.get(middle));
        node.left = listToBST(list, left, middle);
        node.right = listToBST(list, middle + 1, right);
        return node;
    }
}
