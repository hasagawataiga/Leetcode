package Programming_skills_plan.Programming_skills_I;



public class Decrypt_string_from_alphabet_to_integer_mapping{
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if (ch == '#'){
                char currCh = (char)(Integer.parseInt(s.substring(i - 2, i)) + 96);
                i -= 2;
                sb.append(currCh);
            } else {
                sb.append((char)(ch + 48));
            }
        }
        return sb.reverse().toString();
    }
}