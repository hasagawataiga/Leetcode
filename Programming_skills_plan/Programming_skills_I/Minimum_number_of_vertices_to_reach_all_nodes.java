package Programming_skills_plan.Programming_skills_I;

import java.util.ArrayList;
import java.util.List;

public class Minimum_number_of_vertices_to_reach_all_nodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] set = new int[n];
        for (int i = 0; i < edges.size(); i++){
            set[edges.get(i).get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (set[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
