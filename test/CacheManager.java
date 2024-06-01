package test;

import java.util.HashSet;

//////////////////////////////////////////////////////////////////////
//cacheManager
public class CacheManager {
    // גודל מקסימלי
    int maxSize;
    // הממשק
    CacheReplacementPolicy crp;
    // מילים
    HashSet<String> words;

    ///////////////////////////////////////////////////////////////////////
    // קונסטרקטור
    public CacheManager(int size, CacheReplacementPolicy crp) {
        this.maxSize = size;
        this.crp = crp;
        words = new HashSet<>();
    }

    ///////////////////////////////////////////////////////////////////////
    // ADD
    public void add(String word) {
        crp.add(word);
        words.add(word);

        if (words.size() > maxSize) {
            words.remove(crp.remove());
        }
    }

    ///////////////////////////////////////////////////////////////////////
    // QUERY
    public boolean query(String word) {
        return words.contains(word);
    }

}
