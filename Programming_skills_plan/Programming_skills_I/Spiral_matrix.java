package Programming_skills_plan.Programming_skills_I;

public class Spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int l_wall = -1, r_wall = ncol, u_wall = 0, d_wall = nrow;
        char direction = 'r';
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while(result.size() < nrow * ncol) {
            result.add(matrix[i][j]);
            if(direction == 'r') {
                j++;
                if(j == r_wall) {
                    r_wall--;
                    j = r_wall;
                    direction = 'd';
                    i++;
                }
            }
            else if(direction == 'd') {
                i++;
                if(i == d_wall) {
                    d_wall--;
                    i = d_wall;
                    direction = 'l';
                    j--;
                }
            }
            else if(direction == 'l') {
                j--;
                if(j == l_wall) {
                    l_wall++;
                    j = l_wall;
                    direction = 'u';
                    i--;
                }
            }
            else if(direction == 'u') {
                i--;
                if(i == u_wall) {
                    u_wall++;
                    i = u_wall;
                    direction = 'r';
                    j++;
                }
            }
        }
        return result;
    }
}
