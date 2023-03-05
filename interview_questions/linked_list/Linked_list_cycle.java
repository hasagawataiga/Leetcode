package interview_questions.linked_list;

public class Linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        // Using 2 pointer (slow and fast) to traverse the linked list
        // the fastPointer will go further 1 node more than slowPointer for every loop
        // It means that after n times looping, the fastPointer would catch up the slowPointer.
        // (n is equal the distance from the "pos" node to the end of linked list)
        // if they are matched eachother before reaching the end of linked list -> return true.
        // otherwise, return false
        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }
}
