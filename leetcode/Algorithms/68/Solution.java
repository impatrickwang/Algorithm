public class Solution {
	// 21:09
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0;
        int acc = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (acc + words[i].length() + 1 > maxWidth) {
                int n = i-start;
                int r = maxWidth - acc;
                if (n == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[start]);
                    for (int j = 0; j < r; j++) sb.append(' ');
                    res.add(sb.toString());
                } else {
                    int a = r / (n-1);
                    int b = r % (n-1);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n-1; j++) {
                        sb.append(words[start+j]);
                        for (int k = 0; k <= a; k++) sb.append(' ');
                        if (j < b) sb.append(' ');
                    }
                    sb.append(words[start+n-1]);
                    res.add(sb.toString());
                }
                start = i;
                acc = words[i].length();
            } else acc += words[i].length()+1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < words.length-1; i++) {
            sb.append(words[i]);
            sb.append(' ');
        }
        sb.append(words[words.length-1]);
        for (int i = 0; i < maxWidth-acc; i++) sb.append(' ');
        res.add(sb.toString());
        return res;
    }
}
