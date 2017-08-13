public class Solution {
	// 22:11
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = nums[i]+"";
        Arrays.sort(strs, new Comparator<String>() {
			@Override
            public  int compare(String s, String p) {
                int k = 0;
				while (k < s.length() && k < p.length()) {
					if (s.charAt(k) < p.charAt(k)) return -1;
					if (s.charAt(k) > p.charAt(k)) return 1;
					k++;
				}
				if (k >= s.length() && k >= p.length()) return 0;
                if (k < s.length()) return compare(s.substring(k), p);
                return compare(s, p.substring(k));
            }
        });
        StringBuilder res = new StringBuilder();
        for (int i = nums.length-1; i >= 0; i--) res.append(strs[i]);
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.toString();       
    }
}
