package Biweekly_contest.Biwwekly_contest_105;

public class Extra_character_in_a_string {
    public int minExtraChar(String s, String[] dictionary) {
        return extraChar(s, dictionary, 0);
    }
    private int extraChar(String s, String[] dictionary, int index){
        int chars = 0;        
        if (s.isEmpty()){
            return chars;
        }
        boolean couldSplit = false;
        for (int i = index; i < dictionary.length; i++){
            if (s.contains(dictionary[i])){
                String[] strs = s.split(dictionary[i]);
                for (int j = 0; j < strs.length; j++){
                    chars += extraChar(strs[j], dictionary, index + 1);
                    System.out.println(chars + ":" + strs[j]);
                }
                couldSplit = true;
                break;
            }
        }
        return couldSplit ? chars : s.length();
    }
    public int minExtraChar(String s, String[] dictionary) {
        Arrays.sort(dictionary, Comparator.comparingInt(String::length).reversed());
        for (int i = 0; i < dictionary.length; i++){
            System.out.print(dictionary[i] + ", ");
        }
        for (int i = 0; i < dictionary.length; i++){
            if (s.contains(dictionary[i])){g
                s = s.replaceAll(dictionary[i], "1");
            }
        }
        int res = 0;
        for (char ch : s.toCharArray()){
            if (ch != '1'){
                res++;
            }
        }
        return res;
    }
}
