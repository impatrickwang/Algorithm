class Solution {
    public String frequencySort(String s) {
        int[][] cnts = new int[128][2];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i)-0][0] = s.charAt(i)-0;
            cnts[s.charAt(i)-0][1]++;
        }
        Arrays.sort(cnts, (n1, n2) -> n2[1] - n1[1]);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 128 && cnts[i][1] > 0; i++) {
            for (int j = 0; j < cnts[i][1]; j++) {
                res.append((char) cnts[i][0]);
            }
        }
        return res.toString();
    }
}
