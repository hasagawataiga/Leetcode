public class FindClosestNodeToGivenTwoNodes{
    public int core (int[] edges, int node1, int node2){        
        if(node1 > node2){
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }
        if(node2 == edges[node1]){
            return node2;
        }
        int pointer1 = edges[node1];
        int pointer2 = edges[node2];
        int maxDistance = edges.length;
        int distanceNode2 = 0;
        while(pointer2 < edges.length){
            maxDistance = Math.min(maxDistance, isMeeting(edges, pointer1, pointer2, distanceNode2));
            distanceNode2++;
            pointer2 = edges[pointer2];
        }
        return -1;
    }
    public int isMeeting(int[] edges, int pointer1, int pointer2, int distanceNode2){
        int count = distanceNode2;
        while(pointer1 < edges.length){
            if(pointer1 == pointer2){
                return count;
            }
            pointer1 = edges[pointer1];
            count++;
        }
        return -1;
    }
}