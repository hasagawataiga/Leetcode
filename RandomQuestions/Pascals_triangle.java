package RandomQuestions;

import java.util.Arrays;
import java.util.List;

public class Pascals_triangle {
    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        Arrays.fill(row,1);
        // The 2 first rows are all 1's, then we start from 3rd row
        // The first element of row is always 1 -> prev = 1
        //  Caluclate the value of the range 1 -> i - 1 (the value of i index is still 1)
        // The algorithm used here:
        //  the row is acting as a dynamic storage for every single row from the peek (zero index) to rowIndex
        //  after finish a row, we directly use array as a prevRow and store a new value on it
        //  until reaching the rowIndex
        for (int i = 2; i <= rowIndex; i++){
            int prev = 1;
            for (int j = 1; j < i; j++){
                int temp = row[j];
                row[j] = prev + row[j];
                prev = temp;
            }
        }
        return Arrays.asList(row);
    }
}
