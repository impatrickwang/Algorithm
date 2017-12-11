class Solution {
    public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int h = 0;
		if (citations.length > 0) {
			for (int i = 0; i < citations.length/2; i++) {
				int tmp = citations[i];
				citations[i] = citations[citations.length-1-i];
				citations[citations.length-1-i] = tmp;
			}
			while (h < citations.length && citations[h] >= h+1) {
				h++;
			}
		}
		return h; 
    }
}
