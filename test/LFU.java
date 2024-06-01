
package test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFU implements CacheReplacementPolicy {
    LinkedHashMap<String, Integer> frequentlyWords;

    public LFU() {
        frequentlyWords = new LinkedHashMap<>();
    }


    public void add(String word) {
        frequentlyWords.put(word, frequentlyWords.getOrDefault(word, 0) + 1);
    }

    
    public String remove() {// Removing the word with the minimum number times asked
        Map.Entry<String, Integer> min = null;

        for (Map.Entry<String, Integer> entry : frequentlyWords.entrySet()) {
            if (min == null || entry.getValue() < min.getValue()) {
                min = entry;
            }
        }
        return min.getKey();
    }
}
