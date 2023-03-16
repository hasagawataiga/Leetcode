package Recursion.Recurrence_relation;

import java.util.ArrayList;
import java.util.List;

public class Pascals_triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        // Base case: the row always contain 1 at the first position
        row.add(1);
        // The first row has only 1 element
        if (rowIndex == 0){
            return row;
        }
        // Recursion called: to get the previous row value for calculate the current val
        // The first and the last element of this row (except the first row) always be 1
        //  so the loop range is from 1 -> rowIndex instead of 0 -> rowIndex + 1
        //  after add the current value, add the 1 as the tail of the row
        List<Integer> prevRow = getRow(rowIndex - 1);
        for (int i = 1; i < rowIndex; i++){
            int val = prevRow.get(i - 1) + prevRow.get(i);
            row.add(val);
        }
        row.add(1);
        return row;
    }
}
