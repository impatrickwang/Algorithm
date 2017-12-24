class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Integer> airPorts = new HashMap<>();
        List<List<String>> ticketList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < 2; j++) if (!airPorts.containsKey(tickets[i][j])) {
                airPorts.put(tickets[i][j], index++);
                ticketList.add(new LinkedList<String>());
            }
            ticketList.get(airPorts.get(tickets[i][0])).add(tickets[i][1]);
        }
        for (List<String> list:ticketList) list.sort((s1, s2) -> s1.compareTo(s2));
        List<String> res = new ArrayList<>();
        if (!airPorts.containsKey("JFK")) return res;
        res.add("JFK");
        index = airPorts.get("JFK");
        solve(index, res, tickets.length, airPorts, ticketList)
        return res;
    }

    private boolean solve(int index, List<String> res, int l, Map<String, Integer> airPorts, List<List<String>> ticketList) {
        if (res.size() == l+1) return true;
        int size = ticketList.get(index).size();
        for (int i = 0; i < size; i++) {
            int oldIndex = index;
            res.add(ticketList.get(index).remove(i));
            index = airPorts.get(res.get(res.size()-1));
            if (solve(index, res, l, airPorts, ticketList)) return true;
            else ticketList.get(oldIndex).add(i, res.remove(res.size()-1));
        }
        return false;
    }
}
