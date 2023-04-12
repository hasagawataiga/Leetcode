public class Simplify_path {
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        String res = "";
        String[] strings = path.split("/");
        // System.out.println(strings.length);
        // for (String str : strings){
        //     System.out.print(str + ", ");
        // }
        for (int i = 0; i < strings.length; i++){
            String str = strings[i];
            if (str.isEmpty()){
                continue;
            } else if (str.equals(".")){
                if (i < 1){
                    list.add("");
                } else {
                    list.add(strings[i - 1]);
                }
            } else if (str.equals("..")){
                if (i < 1){
                    list.add("");
                } else if (i < 2){
                    list.add(strings[i - 1]);
                } else {
                    list.add(strings[i - 2]);
                }
            } else {
                list.add(str);
            }
        }
        // System.out.println();
        // for (String str : list){
        //     System.out.print(str + ", ");
        // }
        for (String str : list){
            res += "/" + str;
        }
        return res == "" ? "/" : res;
    }
}
