
public class NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges){
        int length = edges.length;
        int[] labels = new int[length];
        for(int i = 0; i < length; i++){
            labels[edges[i]] += i;
            if(labels[edges[i]] < 0){
                labels[edges[i]] = Integer.MAX_VALUE;
            }
        }
        int max = labels[0];
        int maxNode = 0;
        for(int i = 1; i < length; i++){
            if(max < labels[i]){
                maxNode = i;
                max = labels[i];
            }else if((max == labels[i]) && (maxNode > i)){
                maxNode = i;
            }
        }
        return maxNode;
    }
}
