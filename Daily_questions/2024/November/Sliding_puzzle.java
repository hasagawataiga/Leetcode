import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Sliding_puzzle {
    class Solution {
        int totalTiles;
        int targetNumber;
        Set<Integer> existedOrders;
        Queue<int[][]> queue;
        int totalStep;
        public int slidingPuzzle(int[][] board) {
            totalTiles = board.length * board[0].length;
            targetNumber = 123450;
            existedOrders = new HashSet<>();
            queue = new LinkedList<>();
            queue.add(board);
            totalStep = 0;
            int initVal = convertArrayOfIntToNumber(board);
            if (initVal == targetNumber) {
                return 0;
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                totalStep++;
                for (int i = 0; i < size; i++) {
                    int[][] curr = queue.poll();
                    int[] zeroIndex = indexOfZero(curr);

                    if (zeroIndex[1] > 0) {
                        int[][] moveLeft = swapElements(curr, zeroIndex[0], zeroIndex[1], zeroIndex[0], zeroIndex[1] - 1);
                        int newVal = convertArrayOfIntToNumber(moveLeft);
                        updateProcess(moveLeft, newVal);
                        if (checkCurrentStatus(newVal)) {
                            return totalStep;
                        }
                    }
                    if (zeroIndex[1] < board[1].length - 1) {
                        int[][] moveRight = swapElements(curr, zeroIndex[0], zeroIndex[1], zeroIndex[0], zeroIndex[1] + 1);
                        int newVal = convertArrayOfIntToNumber(moveRight);
                        updateProcess(moveRight, newVal);
                        if (checkCurrentStatus(newVal)) {
                            return totalStep;
                        }
                    }
                    if (zeroIndex[0] > 0) {
                        int[][] moveUp = swapElements(curr, zeroIndex[0], zeroIndex[1], zeroIndex[0] - 1, zeroIndex[1]);
                        int newVal = convertArrayOfIntToNumber(moveUp);
                        updateProcess(moveUp, newVal);
                        if (checkCurrentStatus(newVal)) {
                            return totalStep;
                        }
                    }
                    if (zeroIndex[0] < board.length - 1) {
                        int[][] moveDown = swapElements(curr, zeroIndex[0], zeroIndex[1], zeroIndex[0] + 1, zeroIndex[1]);
                        int newVal = convertArrayOfIntToNumber(moveDown);
                        updateProcess(moveDown, newVal);
                        if (checkCurrentStatus(newVal)) {
                            return totalStep;
                        }
                    }
                }
            }
            return -1;
        }

        private boolean checkCurrentStatus(int newVal) {
            if (newVal == targetNumber) {
                return true;
            }
            
            return false;
        }

        private void updateProcess(int[][] newOrder, int newVal) {
            if (!existedOrders.contains(newVal)) {
                existedOrders.add(newVal);
                queue.offer(newOrder);
            }
        }

        private int[] indexOfZero(int[][] array) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == 0) {
                        return new int[]{i, j};
                    }
                }
            }

            return new int[]{0, 0};
        }

        private int convertArrayOfIntToNumber(int[][] array) {
            int num = 0;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    num = num * 10 + array[i][j];
                }
            }

            return num;
        }

        private int[][] swapElements(int[][] array, int i, int j, int a, int b) {
            int[][] tempArray = new int[array.length][array[0].length];

            for (int k = 0; k < array.length; k++) {
                for (int l = 0; l < array[0].length; l++) {
                    tempArray[k][l] = array[k][l];
                }
            }
            int temp = tempArray[a][b];
            tempArray[a][b] = tempArray[i][j];
            tempArray[i][j] = temp;

            return tempArray;
        }
    }
}
