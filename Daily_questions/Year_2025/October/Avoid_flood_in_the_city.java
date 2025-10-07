public class Avoid_flood_in_the_city {
    class Solution {
        public int[] avoidFlood(int[] rains) {
            int[] ans = new int[rains.length];
            Arrays.fill(ans, -1);
            boolean canPreventFlood = true;

            List<Lake> fullLakes = new ArrayList<>();
            int currDryDay = 0;
            for (int i = 0; i < rains.length; i++) {
                if (rains[i] == 0 || rains[i] == -1) {
                    continue;
                }
                Lake currLake = new Lake(rains[i], i);
                if (fullLakes.contains(currLake)) {
                    Lake prevLake = fullLakes.get(fullLakes.indexOf(currLake));
                    currDryDay = findDryDay(rains, prevLake.position, i);
                    if (currDryDay == -1) {
                        return new int[0];
                    }
                    prevLake.position = i;
                    ans[currDryDay] = rains[i];
                    rains[i] = -1;
                } else {
                    fullLakes.add(new Lake(rains[i], i));
                }
            }

            // Fill all unused dry day with 1
            for (int i = 0; i < rains.length; i++) {
                if (rains[i] == 0) {
                    ans[i] = 1;
                }
            }

            return ans;
        }

        private int findDryDay(int[] rains, int min, int max) {
            int index = min;
            while (index < max) {
                if (rains[index] == 0) {
                    rains[index] = -1;
                    return index;
                }
                index++;
            }

            return -1;
        }

        class Lake {
            int position;
            int name;
            Lake(int name, int position) {
                this.name = name;
                this.position = position;
            }

            @Override
            public boolean equals(Object o) {
                if (o instanceof Lake) {
                    Lake other = (Lake) o;
                    if (this.name == other.name) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
