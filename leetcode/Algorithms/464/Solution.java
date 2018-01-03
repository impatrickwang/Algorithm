class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger*(maxChoosableInteger+1)/2 < desiredTotal) return false;
        return solve(0, maxChoosableInteger, desiredTotal, new HashMap<Integer, Boolean>());
    }

    private boolean solve(int used, int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> map) {
        if (map.containsKey(used)) return map.get(used);
        int mask = 1;
        boolean res = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((used & mask) == 0) {
                if (i+1 >= desiredTotal) {
                    res = true;
                    break;
                } else {
                    used ^= mask;
                    boolean r = solve(used, desiredTotal-i-1, map);
                    used ^= mask;
                    if (!r) {
                       res = true;
                       break;
                    }
                }
            }
            mask = mask << 1;
        }
        map.put(used, res);
        return res;
    }
}
