class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = find(arr, 0, arr.length-1, x);    
        List<Integer> res = new LinkedList<>();
        int h = l+1;
        while (res.size() < k) {
            if (l >= 0 && h < arr.length) {
                if (x-arr[l] <= arr[h]-x) res.add(0, arr[l--]);
                else res.add(arr[h++]);
            } else if (l >= 0) res.add(0, arr[l--]);
            else res.add(arr[h++]);
        }
        return res;
    }

    private int find(int[] arr, int l, int h, int x) {
        if (l > h) return h;
        int m = (l+h)/2;
        if (arr[m] == x) return m;
        else if (arr[m] < x) return find(arr, m+1, h, x);
        else return find(arr, l, m-1, x);
    }
}
