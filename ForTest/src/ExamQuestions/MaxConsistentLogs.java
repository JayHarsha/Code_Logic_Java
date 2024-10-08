package ExamQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxConsistentLogs {
    public static int maxConsistentLogs(int[] userEvent) {
        int n = userEvent.length;
        Map<Integer, Integer> globalFreq = new HashMap<>();
        int minFreq = Integer.MAX_VALUE;

        // Calculate global frequency and find minimum frequency
        for (int userId : userEvent) {
            globalFreq.put(userId, globalFreq.getOrDefault(userId, 0) + 1);
        }
        for (int freq : globalFreq.values()) {
            minFreq = Math.min(minFreq, freq);
        }

        int maxLength = 0;
        int left = 0;
        Map<Integer, Integer> windowFreq = new HashMap<>();
        int maxFreqInWindow = 0;

        // Sliding window approach
        for (int right = 0; right < n; right++) {
            int userId = userEvent[right];
            windowFreq.put(userId, windowFreq.getOrDefault(userId, 0) + 1);
            maxFreqInWindow = Math.max(maxFreqInWindow, windowFreq.get(userId));

            // Shrink window if condition is violated
            while (maxFreqInWindow > minFreq) {
                int leftUserId = userEvent[left];
                windowFreq.put(leftUserId, windowFreq.get(leftUserId) - 1);
                if (windowFreq.get(leftUserId) == 0) {
                    windowFreq.remove(leftUserId);
                }
                left++;

                // Update maxFreqInWindow
                maxFreqInWindow = Collections.max(windowFreq.values());
            }

            // Update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] userEvent = {1, 2, 2, 3, 1, 2};
        System.out.println("Maximum length of consistent logs: " + maxConsistentLogs(userEvent));
    }
}