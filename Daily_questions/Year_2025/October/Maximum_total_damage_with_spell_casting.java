public class Maximum_total_damage_with_spell_casting {
    class Solution {
        public long maximumTotalDamage(int[] power) {
            Long ans = 0L;
            List<Spell> uniqueSpells = new ArrayList<>();
            Map<Integer, Long> spellDamages = new HashMap<>();
            for (int spell : power) {
                spellDamages.put(spell, spellDamages.getOrDefault(spell, 0L) + spell);
            }
            for (Map.Entry<Integer, Long> entry : spellDamages.entrySet()) {
                uniqueSpells.add(new Spell(entry.getKey(), entry.getValue()));
            }
            Collections.sort(uniqueSpells, (s1, s2) -> Integer.compare(s1.power, s2.power));

            long[] dp = new long[uniqueSpells.size()];
            for (int i = 0; i < uniqueSpells.size(); i++) {
                Spell currSpell = uniqueSpells.get(i);
                int prevIndex = findMostClosePrevSpell(uniqueSpells, currSpell.power - 3);
                long spellCasted = currSpell.damage;
                if (prevIndex != -1) {
                    spellCasted += dp[prevIndex];
                }
                long spellIgnored = i >= 1 ? dp[i - 1] : 0;
                // System.out.println(spellCasted + "  " + spellIgnored);
                dp[i] = Math.max(spellCasted, spellIgnored);
            }

            return dp[uniqueSpells.size() - 1];
        }

        private int findMostClosePrevSpell(List<Spell> list, int target) {
            int left = 0;
            int right = list.size() - 1;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (list.get(mid).power <= target) {
                    left = mid + 1;
                    ans = mid;
                } else {
                    right = mid - 1;
                }
            }
            // System.out.println(ans); 
            return ans;
        }

        class Spell {
            int power;
            long damage;
            Spell(int power, long damage) {
                this.power = power;
                this.damage = damage;
            }

            Spell(int power) {
                this.power = power;
                this.damage = 0;
            }

            @Override
            public boolean equals(Object other) {
                if (other instanceof Spell) {
                    Spell spell = (Spell) other;
                    return this.power == spell.power;
                }
                return false;
            }
        }
    }
}
