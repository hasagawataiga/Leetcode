public class Remove_sub_folders_from_filesystem {
    class Solution {
        public List<String> removeSubfolders(String[] folders) {
            List<String> ans = new ArrayList<>();
            Arrays.sort(folders);
            String prevFolder = "none";
            for (int i = 0; i < folders.length; i++) {
                if (folders[i].startsWith(prevFolder)) {
                    continue;
                } else {
                    ans.add(folders[i]);
                    prevFolder = folders[i] + "/";
                }
            }
            return ans;
        }
    }
}