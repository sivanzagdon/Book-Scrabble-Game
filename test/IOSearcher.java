package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class IOSearcher {
    public static boolean search(String word, String... fileNames) throws RuntimeException, IOException {
        for (int i = 0; i < fileNames.length; i++) {
            if (isWordInFile(word, fileNames[i])) {
                return true;
            }
        }

        return false;
    }

   
    public static boolean isWordInFile(String word, String fileName) throws RuntimeException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(word)) {
                reader.close();
                return true;
            }
        }

        reader.close();
        return false;
    }
}
