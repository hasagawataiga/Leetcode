package interview_questions.linked_list;

public class Delete_node_in_a_linked_list {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
