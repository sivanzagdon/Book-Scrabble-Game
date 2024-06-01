package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

////////////////////////////////////////////////////////////////////
//IOSearcher
public class IOSearcher {
    // פונקציית חיפוש
    public static boolean search(String word, String... fileNames) throws RuntimeException, IOException {
        // עוברים על כל השמות
        for (int i = 0; i < fileNames.length; i++) {
            if (isWordInFile(word, fileNames[i])) {
                return true;
            }
        }

        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // האם המילה בתוך הקובץ?
    public static boolean isWordInFile(String word, String fileName) throws RuntimeException, IOException {
        // מגדיריפ באפר
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
