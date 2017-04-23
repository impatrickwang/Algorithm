public class Solution {
    public String longestPalindrome(String s) {
	if (s.length() < 2) return s;
	StringBuilder sb = new StringBuilder();
	sb.append('#');
	for (int i = 0; i < s.length(); i++) {
		sb.append(s.charAt(i));
		sb.append('#');
	}
	return exec(sb.toString());
    }

    private String exec(String s) {
	int[] len = new int[s.length()];
	len[1] = 1;
	int maxIndex = 1;
	int resIndex = 1;
	for (int i = 2; i < s.length(); i++) {
	    int mirrorIndex = maxIndex * 2 - i;
	    if (mirrorIndex >= 0 && mirrorIndex - len[mirrorIndex] > maxIndex - len[maxIndex]) len[i] = len[mirrorIndex];
	    else {
	        len[i] = mirrorIndex < 0 ? 0 : mirrorIndex - (maxIndex - len[maxIndex]);
		while (i-len[i]-1 >= 0 && i+len[i]+1 < s.length() && s.charAt(i-len[i]-1) == s.charAt(i+len[i]+1)) {
		    len[i]++;
		}
		if (i+len[i] > maxIndex+len[maxIndex]) maxIndex = i;
	    }
	    if (len[i] > len[resIndex]) resIndex = i;
	}
	StringBuilder sb = new StringBuilder();
	for (int i = resIndex-len[resIndex]; i <= resIndex+len[resIndex]; i++) if (s.charAt(i) != '#') sb.append(s.charAt(i));
	return sb.toString();
    }
}
