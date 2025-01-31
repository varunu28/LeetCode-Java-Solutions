class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> eventLog) {
        List<Event> events = eventLog.stream()
            .map(Event::buildEvent)
            .sorted()
            .collect(Collectors.toList());
        Map<Integer, Integer> offlineUsers = new HashMap<>();
        int[] mentions = new int[numberOfUsers];
        for (Event event : events) {
            if (event.message().equals("OFFLINE")) {
                offlineUsers.put(Integer.parseInt(event.mentionString()), event.timestamp());
            } else {
                int timestamp = event.timestamp();
                List<Integer> onlineUsers = offlineUsers.entrySet()
                    .stream()
                    .filter(t -> timestamp - t.getValue() >= 60)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
                onlineUsers.forEach(offlineUsers::remove);
                String mentionString = event.mentionString();
                if (mentionString.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                } else if (mentionString.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (!offlineUsers.containsKey(i)) {
                            mentions[i]++;
                        }
                    }
                } else {
                    String[] usersMentioned = mentionString.split(" ");
                    for (String user : usersMentioned) {
                        int userId = Integer.parseInt(user.substring(2));
                        mentions[userId]++;
                    }
                }
            }
        }
        return mentions;
    }

    private record Event(String message, int timestamp, String mentionString) implements Comparable<Event> {

        public static Event buildEvent(List<String> event) {
            String message = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            String mentionString = event.get(2);
            return new Event(message, timestamp, mentionString);
        }

        @Override
        public int compareTo(Event o) {
            int c = this.timestamp - o.timestamp;
            if (c != 0) {
                return c;
            }
            return o.message().compareTo(this.message());
        }
    }
}
