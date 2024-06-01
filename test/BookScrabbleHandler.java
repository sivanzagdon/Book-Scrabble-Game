package test;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/////////////////////////////////////////////////////////////////////////////
//ClientHandler
public class BookScrabbleHandler implements ClientHandler {
    // DictionaryManager
    DictionaryManager dm;
    // PrintWriter
    PrintWriter out;
    // Scanner
    Scanner in;

    //////////////////////////////////////////////////////////////////////////////
    // גיבוב
    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {
        out = new PrintWriter(outToClient);
        in = new Scanner(inFromClient);
        dm = DictionaryManager.get();
        String[] inputFromClient = in.next().split(",");
        boolean wordExists = false;

        if (inputFromClient.equals('Q')) {
            wordExists = dm.query(Arrays.copyOfRange(inputFromClient, 1, inputFromClient.length));
        } else {
            wordExists = dm.challenge(Arrays.copyOfRange(inputFromClient, 1, inputFromClient.length));
        }

        out.println(wordExists ? "true" : "false");
        out.flush();
    }
    ////////////////////////////////////////////////////////////////////////////
    // סגירה

    @Override
    public void close() {
        out.close();
        in.close();
    }
}