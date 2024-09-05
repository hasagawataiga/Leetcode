public class Walking_robot_simulation {
    class Solution {
        Direction[] directions = Direction.values();
        Coor coor = new Coor(0 ,0);
        Direction currDirection = Direction.NORTH;
        int maxDist = 0;
        public int robotSim(int[] commands, int[][] obstacles) {
            for (int i = 0; i < commands.length; i++) {
                if (commands[i] == -1) {
                    currDirection = currDirection.changeDirection(DirectionTurn.RIGHT);
                } else if (commands[i] == -2) {
                    currDirection = currDirection.changeDirection(DirectionTurn.LEFT);
                } else {
                    Coor nextCoor = new Coor(coor);
                    nextCoor.moveTo(currDirection, commands[i]);
                    if (!isBlockedByObstacles(obstacles, coor, nextCoor)) {
                        coor.moveTo(currDirection, commands[i]);
                    }
                    maxDist = Math.max(maxDist, coor.getDist());
                }
            }
            return maxDist;
        }

        private boolean isBlockedByObstacles (int[][] obstacles, Coor coor1, Coor coor2) {
            int x1 = coor1.getX();
            int y1 = coor1.getY();
            int x2 = coor2.getX();
            int y2 = coor2.getY();
            boolean isBlocked = false;
            for (int i = 0; i < obstacles.length; i++) {
                int x = obstacles[i][0];
                int y = obstacles[i][1];
                if (currDirection == Direction.NORTH && y > y1 && y <= y2 && x == x1) {
                    coor1.setY(y - 1);
                    isBlocked = true;
                    break;
                }
                if (currDirection == Direction.EAST && x > x1 && x <= x2 && y == y1) {
                    coor1.setX(x - 1);
                    isBlocked = true;
                    break;
                }
                if (currDirection == Direction.SOUTH && y < y1 && y >= y2 && x == x1) {
                    coor1.setY(y + 1);
                    isBlocked = true;
                    break;
                }
                if (currDirection == Direction.WEST && x < x1 && x >= x2 && y == y1) {
                    coor1.setX(x + 1);
                    isBlocked = true;
                    break;
                }
            }
            if (isBlocked) {
                return true;
            }
            return false;
        }
    }
    
    class Coor {
        private int x;
        private int y;
        Coor (int x, int y) {
            this.x = x;
            this.y = y;
        }
        Coor (Coor coor) {
            this.x = coor.getX();
            this.y = coor.getY();
        }
        public void moveTo(Direction direction, int units) {
            switch (direction) {
                case NORTH:
                    this.y += units;
                    break;
                case EAST:
                    this.x += units;
                    break;
                case SOUTH:
                    this.y -= units;
                    break;
                case WEST:
                    this.x -= units;
                    break;
            }
        }
        public void setX(int x) {this.x = x;}
        public void setY(int y) {this.y = y;}
        public int getX() {return this.x;}
        public int getY() {return this.y;}
        public int getDist() {return (int)(Math.pow(x, 2) + Math.pow(y, 2));}
    }

    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;
        public Direction changeDirection(DirectionTurn directionTurn) {
            // Calculate the next index based on the current direction and the turn direction
            int directionCount = Direction.values().length;
            int currentIndex = this.ordinal();
            if (directionTurn == DirectionTurn.LEFT) {
                // Turn left (anti-clockwise)
                currentIndex = (currentIndex - 1 + directionCount) % directionCount;
            } else if (directionTurn == DirectionTurn.RIGHT) {
                // Turn right (clockwise)
                currentIndex = (currentIndex + 1) % directionCount;
            }
            // Return the new direction
            return Direction.values()[currentIndex];
        }
    }
    
    enum DirectionTurn {
        LEFT,
        RIGHT
    }

    public static void main(String[] args) {
        // int[] commands = {4, -1, 4, -2, 4};
        int[] commands = {1, -1, 1, -1, 1, -1, 6};
        // int[][] obstacles = {{2, 4}};
        int[][] obstacles = {{0, 0}};
        Walking_robot_simulation instance = new Walking_robot_simulation();
        Solution solution = instance.new Solution();
        int dist = solution.robotSim(commands, obstacles);
        System.out.println(dist);
    }
}

