public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return doFind(nums1, nums2);
        else return doFind(nums2, nums1);
    }
    
    private double doFind(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int M = nums2.length;
        int halfNum = (N+M)/2;
        int l = 0;
        int h = nums1.length;
        double result = 0;
        while (l <= h) {
            int n = (l+h)/2;
            int m = halfNum-n;
            if (n < N && nums1[n] < nums2[m-1]) l = n+1;
            else if (n > 0 && nums2[m] < nums1[n-1]) h = n-1;
            else {
                result = median(nums1, nums2, n, m);
                break;
            }
        }
        return result;
    }
    
    private double median(int[] nums1, int[] nums2, int n, int m) {
        if ((nums1.length+nums2.length)%2 == 1) {
            if (n >= nums1.length) return (double) nums2[m];
            if (m >= nums2.length) return (double) nums1[n];
            return (double) Math.min(nums1[n], nums2[m]);
        } else {
            int l = n == 0 ? nums2[m-1] : m == 0 ? nums1[n-1] : Math.max(nums1[n-1], nums2[m-1]);
            int r = n >= nums1.length ? nums2[m] : m >= nums2.length ? nums1[n] : Math.min(nums1[n], nums2[m]);
            return ((double) l+r)/2;
        }
    }
}
