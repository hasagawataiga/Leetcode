package Programming_skills_plan.Programming_skills_I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_greater_element_i {
    // Assume the array has non-increasing order elements: 9 8 7 6 5 4 3 2 1
    // Use stack to handle the "weird" element:
    //  In details, push elements into stack until reach a greater element
    //      when we reach the greater element then the most top of stack, we pop this elements out of stack
    //           and repeat this action until the most top element of stack is not less than the num
    //  Store all the stack elements were popped out with the num value
    //  Extract the next greater element result from this map
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2){
            while (!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
