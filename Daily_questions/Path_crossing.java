import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Path_crossing {
    class Solution {
        class Coordinate {
            int x;
            int y;
            Coordinate (int x, int y) {
                this.x = x;
                this.y = y;
            }
            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Coordinate coordinate = (Coordinate) obj;
                return x == coordinate.x && y == coordinate.y;
            }
            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
        public boolean isPathCrossing(String path) {
            Set<Coordinate> locations = new HashSet<>();
            int x = 0;
            int y = 0;
            locations.add (new Coordinate(x, y));
            for (char ch : path.toCharArray()) {
                switch (ch) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'S':
                        y--;
                        break;
                }
                if (!locations.add(new Coordinate(x, y))) {
                    return true;
                }
            }
            return false;
        }
    }
}
