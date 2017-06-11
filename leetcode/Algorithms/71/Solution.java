public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        List<String> stack = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].length() > 0) {
                if (".".equals(paths[i])) continue;
                else if ("..".equals(paths[i])) {
                    if (!stack.isEmpty()) stack.remove(stack.size()-1);
                }
                else stack.add(paths[i]);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/");
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
