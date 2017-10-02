class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') nums.add(0);
            else if (input.charAt(i) == '-') nums.add(1);
            else if (input.charAt(i) == '*') nums.add(2);
            else {
                int num = 0;
                do {
                    num = num*10 + input.charAt(i) - '0';
                    i++;
                } while (i < input.length() && input.charAt(i) <= '9' && input.charAt(i) >= '0');
                nums.add(num);
                i--;
            }
        }
        return compute(nums, 0, nums.size()-1);
    }

    private List<Integer> compute(List<Integer> nums, int l, int h) {
        assert(l % 2 == 0 && h % 2 == 0);
        List<Integer> res = new ArrayList<>();
        if (l == h) res.add(nums.get(l));
        else {
            for (int i = l+1; i < h; i+=2) {
                List<Integer> ll = compute(nums, l, i-1);
                List<Integer> rl = compute(nums, i+1, h);
                for (int j = 0; j < ll.size(); j++) {
                    for (int k = 0; k < rl.size(); k++) {
                        switch(nums.get(i)) {
                            case 0:
                                res.add(ll.get(j)+rl.get(k));
                                break;
                            case 1:
                                res.add(ll.get(j)-rl.get(k));
                                break;
                            case 2:
                                res.add(ll.get(j)*rl.get(k));
                                break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
