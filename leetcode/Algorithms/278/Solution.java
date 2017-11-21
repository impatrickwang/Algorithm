/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l = 1;
        long h = n;
        while (l < h) {
            long m = (l+h)/2;
            if (isBadVersion((int)m)) h = m;
            else l = m+1;
        }
        return (int) l;
    }
}
