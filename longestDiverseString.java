class Solution {
    class Pair {
        char ch;
        int fq;

        Pair(char ch, int fq) {
            this.ch = ch;
            this.fq = fq;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> p = new PriorityQueue<>((e, f) -> f.fq - e.fq);

        // Only add pairs with frequency > 0
        if (a > 0) p.add(new Pair('a', a));
        if (b > 0) p.add(new Pair('b', b));
        if (c > 0) p.add(new Pair('c', c));

        StringBuilder sb = new StringBuilder();

        while (!p.isEmpty()) {
            Pair pair = p.poll(); // Get the character with the highest frequency
            char curr = pair.ch;
            int freq = pair.fq;

            if (sb.length() == 0 || sb.length() < 2 || sb.charAt(sb.length() - 1) != curr || sb.charAt(sb.length() - 2) != curr) {
                // Append the current character
                sb.append(curr);
                pair.fq--; // Decrease frequency after using the character

                if (pair.fq > 0) {
                    p.add(pair); // Add back to the queue if there are more occurrences left
                }
            } else {
                // If the current character would cause a triple repetition, skip it and use another character
                if (p.isEmpty()) break; // No other character available, break the loop

                Pair nextPair = p.poll(); // Get the next highest frequency character
                sb.append(nextPair.ch);
                nextPair.fq--; // Decrease frequency of the next character

                if (nextPair.fq > 0) {
                    p.add(nextPair); // Add back to the queue if there are more occurrences left
                }
                p.add(pair); // Add the blocked character back to the queue
            }
        }

        return sb.toString();
    }
}
