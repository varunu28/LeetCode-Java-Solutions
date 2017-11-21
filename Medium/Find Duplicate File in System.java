class Solution {
    
    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String s : paths) {
            String[] temp = s.split("\\s");

            for (int i=1;i<temp.length;i++) {
                String message = temp[i].substring(temp[i].indexOf("(")+1, temp[i].indexOf(")"));
                String fileName = temp[i].substring(0, temp[i].indexOf("("));

                if (map.containsKey(message)) {
                    ArrayList<String> tempList = map.get(message);
                    tempList.add(temp[0] + "/" + fileName);
                    map.put(message, tempList);
                }
                else {
                    ArrayList<String> tempList = new ArrayList<>();
                    tempList.add(temp[0] + "/" + fileName);
                    map.put(message, tempList);
                }

            }
        }

        for (Map.Entry<String,ArrayList<String>> entry : map.entrySet()) {

            List<String> l = entry.getValue();

            if (l.size() > 1) {
                ans.add(l);
            }
            
        }

        return ans;
    }
}
