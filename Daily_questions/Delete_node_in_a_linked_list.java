import interview_questions.linked_list.ListNode;

class Delete_node_in_a_linked_list {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}