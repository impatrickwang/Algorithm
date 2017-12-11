class Solution {
    public int hIndex(int[] citations) {
        int h = 0;
        if (citations.length > 0) {
            while (h < citations.length && citations[citations.length-1-h] >= h+1) {
                h++;
            }
        }
        return h;        
    }
}
