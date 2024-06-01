package test;

import java.util.HashMap;

public class DictionaryManager {

    private static DictionaryManager dictionary_manager = null;
    HashMap<String, Dictionary> map;

    
    private DictionaryManager() {
        map = new HashMap<String, Dictionary>();
    }

    
    public int getSize() {
        return map.size();
    }

    
    public boolean query(String... args) {
    
        String word = args[args.length - 1];
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
   

    public static DictionaryManager get() {
        if (dictionary_manager == null) {
            dictionary_manager = new DictionaryManager();
        }
        return dictionary_manager;
    }

    
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
