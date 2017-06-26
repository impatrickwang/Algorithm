public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int l = m+n-1; l >= 0; l--) {
            if (m > 0 && n > 0) nums1[l] = nums1[m-1] >= nums2[n-1] ? nums1[--m] : nums2[--n];
            else if (n > 0) nums1[l] = nums2[--n];
        }
    }
}
