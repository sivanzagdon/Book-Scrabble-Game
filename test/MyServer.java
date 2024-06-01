package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

//////////////////////////////////////////////////////////////////////////////
//MyServer
public class MyServer {
    // פורט
    int port;
    // client handler
    ClientHandler ch;
    // עצירה
    volatile boolean stop;

    /////////////////////////////////////////////////////////////////////////////////////////
    // קונסטרקטור

    MyServer(int port, ClientHandler ch) {
        this.port = port;
        this.ch = ch;
        stop = false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // start
    void start() {
        new Thread(() -> runServer()).start();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // פונקציית ריצת השרת
    private void runServer() {
        // פותחים סוקט
        ServerSocket server = null;
        try {
            // פותחים שרת
            server = new ServerSocket(port);
            server.setSoTimeout(1000);
            // לולאת while
            while (!stop) {
                try {
                    // פתייחת סוקט
                    Socket client = server.accept();
                    try {
                        ch.handleClient(client.getInputStream(), client.getOutputStream());
                        client.close();

                    } catch (IOException e) {
                        // System.out.println("IOException");
                    }
                } catch (SocketTimeoutException e) {
                    // System.out.println("SocketTimeoutException");
                }
            }

            server.close();
        } catch (Exception e) {
            // System.out.println(e);
        }
    }

    //////////////////////////////////////////////
    // סגירה של התהליך
    void close() {
        stop = true;
    }
}
