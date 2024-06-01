package test;

import java.util.HashMap;

////////////////////////////////////////////////////////////////
//DictionaryManager
public class DictionaryManager {
    // הגדרת משתנים
    private static DictionaryManager dictionary_manager = null;
    HashMap<String, Dictionary> map;

    ///////////////////////////////////////////////////////////////////
    // קונסטרקטור
    private DictionaryManager() {
        map = new HashMap<String, Dictionary>();
    }

    /////////////////////////////////////////////////
    // GET SIZE
    public int getSize() {
        return map.size();
    }

    ////////////////////////////////////////////////////////////////////////////
    // שאליתה
    public boolean query(String... args) {
        // word
        String word = args[args.length - 1];
        // האם קיים
        boolean wordExists = false;
        for (int i = 0; i < args.length - 1; i++) {
            if (!map.containsKey(args[i])) {
                map.put(args[i], new Dictionary(args[i]));
            }
            if (map.get(args[i]).query(word)) {
                wordExists = true;
            }
        }
        return wordExists;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // DictionaryManager

    public static DictionaryManager get() {
        if (dictionary_manager == null) {
            dictionary_manager = new DictionaryManager();
        }
        return dictionary_manager;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // challenge
    public boolean challenge(String... args) {
        String word = args[args.length - 1];
        boolean wordExists = false;
        for (int i = 0; i < args.length - 1; i++) {
            if (!map.containsKey(args[i])) {
                map.put(args[i], new Dictionary(args[i]));
            }

            if (map.get(args[i]).challenge(word)) {
                wordExists = true;
            }
        }

        return wordExists;
    }

}
