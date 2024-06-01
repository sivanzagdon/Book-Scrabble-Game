package test;

import java.util.LinkedHashSet;


public class LRU implements CacheReplacementPolicy {
    LinkedHashSet<String> recentlyWords;

    public LRU() {
        recentlyWords = new LinkedHashSet<>();
    }


    public String remove() {
        String firstWord = recentlyWords.iterator().next();
        recentlyWords.remove(firstWord);
        return firstWord;
    }

    
    public void add(String word) {
        recentlyWords.remove(word);
        recentlyWords.add(word);
    }
}
