
package test;

import java.util.LinkedHashMap;
import java.util.Map;

///////////////////////////////////////////////////////////////////////////////////
//LFU
//יורש ממנו
public class LFU implements CacheReplacementPolicy {
    LinkedHashMap<String, Integer> frequentlyWords;

    // קונסטרקטור
    public LFU() {
        frequentlyWords = new LinkedHashMap<>();
    }

    ////////////////////
    // ADD
    public void add(String word) {
        frequentlyWords.put(word, frequentlyWords.getOrDefault(word, 0) + 1);
    }

    ////////////////////////////////////////////////////////////////////////////////
    // פונקציית הסר
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
