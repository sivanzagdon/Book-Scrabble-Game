package test;

import java.util.LinkedHashSet;

//////////////////////////////////////////////////////////////////////////
//LFU
//יורש ממנו
public class LRU implements CacheReplacementPolicy {
    LinkedHashSet<String> recentlyWords;

    // קונסטרקטור
    public LRU() {
        recentlyWords = new LinkedHashSet<>();
    }

    ////////////////////////////////////////////////////////////////////////////////
    // פונקציית הסרה
    public String remove() {
        String firstWord = recentlyWords.iterator().next();
        recentlyWords.remove(firstWord);
        return firstWord;
    }

    /////////////////////////////////////////////////////////////////////////
    // פונקציית הוספה
    public void add(String word) {
        recentlyWords.remove(word);
        recentlyWords.add(word);
    }
}
