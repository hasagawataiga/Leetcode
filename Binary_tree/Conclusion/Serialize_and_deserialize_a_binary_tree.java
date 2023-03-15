package Binary_tree.Conclusion;

import interview_questions.trees.TreeNode;

public class Serialize_and_deserialize_a_binary_tree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        return serialize(root, stringBuilder).toString();
    }
    private StringBuilder serialize(TreeNode node, StringBuilder stringBuilder){
        if (node == null){
            stringBuilder.append("ll");
            stringBuilder.append(",");
        } else {
            stringBuilder.append(node.val);
            stringBuilder.append(",");
            serialize(node.left, stringBuilder);
            serialize(node.right, stringBuilder);
        }
        return stringBuilder;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        // Using int[] index instead of int index because in Java, primitive type always be put into method (parameter) as value
        //  when calling recursion calls, the int index changed is applied only inside this method, not the int index (the original)
        int[] index = new int[]{0};
        return deserialize(dataArray, index);
    }
    private TreeNode deserialize(String[] data, int[] index){
        if (index[0] >= data.length){
            return null;
        }
        String value = data[index[0]];
        index[0]++;
        if (value.equals("ll")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(value));
        // The code below are the reason why we are using int[] index instead of int index
        //  Assume we use int index, there would be a big problem:
        //  the code: node.left = deserialize(data, index) called
        //      -> index value would be changed, but it is not applied to the second method (node.right = deserialize(data, index))
        //      while the index have to be + 1 for every single element of String[] data was taken
        // In this case, we need a type of variable can be change in the memory (int index will be create a new one and pass into the method as a value)
        // There are several way to get it: use array (int[] index), MutableInt,...
        node.left = deserialize(data, index);
        node.right = deserialize(data, index);
        return node;
    }
}
