package Programming_skills_plan.Programming_skills_I;



// I tried to create an algorithm to be used in a more generic formed (like 16, 25 cells instead of only 9 cells)
// It is not perfect tho, but it is more generic than other solutions on leetcode which I could found
// 3 arrays for counting the cells have chosen:
//      diagonalCount[0]: the diagonal from top left to bottom right
//      diagonalCount[1]: the diagonal from bottom left to top right
//      rowCount[number of rows]: represented for row from 0-th to r-th
//      colCount[number of cols]: represented for col from 0-th to c-th
public class Find_winner_in_a_tic_tac_toe_game {
    public String tictactoe(int[][] moves) {
        String res = "Pending";
        char[][] table = new char[3][3];
        int[] diagonalCount = new int[2];
        int[] rowCount = new int[3];
        int[] colCount = new int[3];
        for (int i = 0; i < moves.length; i++){
            char player = i % 2 == 0 ? 'A' : 'B';
            table[moves[i][0]][moves[i][1]] = player;
            if (moves[i][0] == moves[i][1]){
                if (moves[i][0] == 1){
                    diagonalCount[1]++;
                }
                diagonalCount[0]++;
            }
            if (Math.abs(moves[i][0] - moves[i][1]) == 2){
                diagonalCount[1]++;
            }
            rowCount[moves[i][0]]++;
            colCount[moves[i][1]]++;
            if (diagonalCount[0] == 3 || diagonalCount[1] == 3){
                if (checkDiagonal(table)){
                    return player + "";
                }
            }
            if (rowCount[0] == 3 || rowCount[1] == 3 || rowCount[2] == 3){
                if (checkRow(table, player, moves[i][0])){
                    return player + "";
                }
            }
            if (colCount[0] == 3 || colCount[1] == 3 || colCount[2] == 3){
                if (checkCol(table, player, moves[i][1])){
                    return player + "";
                }
            }
            // System.out.print(i + 1 + " -> ");
            // System.out.println();
            // printTable(table);
            // System.out.println();
        }
        return moves.length == 9 ? "Draw" : res;
    }
    private boolean checkDiagonal(char[][] table){
        if (table[0][0] == table[1][1] && table[1][1] == table[2][2]){
            return true;
        }
        if (table[0][2] == table[1][1] && table[1][1] == table[2][0]){
            return true;
        }
        return false;
    }
    private boolean checkRow(char[][] table, char player, int row){
        for (int i = 0; i < 2; i++){
            if (table[row][i] != table[row][i + 1]){
                return false;
            }
        }
        return true;
    }
    private boolean checkCol(char[][] table, char player, int col){
        for (int i = 0; i < 2; i++){
            if (table[i][col] != table[i + 1][col]){
                return false;
            }
        }
        return true;
    }
    private void printTable(char[][] table){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(i * 3 + j + 1 + ":" + table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
