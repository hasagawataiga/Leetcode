package Contest.Contest341;

public class Minimum_additions_to_make_valid_string {
    public int addMinimum(String word) {
        int count = 0;
        if (word.length() == 1){
            return 2;
        }
        char preCh = word.charAt(0);
        if (preCh == 'b'){
            count = 1;
        } else if (preCh == 'c'){
            count = 2;
        }
        int i = 1;
        for (; i < word.length(); i++){
            char ch = word.charAt(i);
            if (ch == 'b'){
                if (preCh == 'b'){
                    count += 2;
                } else if (preCh == 'c'){
                    count++;
                }
            } else if (ch == 'c'){
                if (preCh == 'a'){
                    count++;
                } else if (preCh == 'c'){
                    count += 2;
                }
            } else {
                if (preCh == 'b'){
                    count++;
                } else if (preCh == 'a'){
                    count += 2;
                }
            }
            preCh = ch;
        }
        if (word.charAt(i - 1) == 'a'){
            count += 2;
        } else if (word.charAt(i - 1) == 'b'){
            count++;
        }
        return count;
    }
}
