public class Solution {
    private static char[][] tab = new char[][] {
	{},
	{},
	{'a', 'b', 'c'},
	{'d', 'e', 'f'},
	{'g', 'h', 'i'},
	{'j', 'k', 'l'},
	{'m', 'n', 'o'},
	{'p', 'q', 'r', 's'},
	{'t', 'u', 'v'},
	{'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
	if (digits.length() < 1 || digits.contains("1") || digits.contains("0")) return new ArrayList<String>();
        return f(digits, 0);
    }

    private List<String> f(String digits, int index) {
	if (index == digits.length()) {
	    List<String> list = new ArrayList<>();
	    list.add("");
	    return list;
	}
	List<String> list = f(digits, index+1);
	if (tab[digits.charAt(index) - '0'].length < 1) return list;
	List<String> newList = new ArrayList<>();
	for (int i = 0; i < tab[digits.charAt(index) - '0'].length; i++) 
	    for (String s:list) newList.add(tab[digits.charAt(index)-'0'][i]+s);
	return newList;
    }
}
