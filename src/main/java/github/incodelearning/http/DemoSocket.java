package github.incodelearning.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client and server can send and receive byte streams over a connection. The HTTP 1.1 supports seven types of
 * request: GET, POST, HEAD, OPTIONS, PUT, DELETE, and TRACE. HTTP 0.9, 1.0, 1.1 (RFC 2616).
 * <p>
 * UDP is connectionless, meaning there is no session between the client and the server while TCP is
 * connection-oriented.
 * <p>
 * Socket constructor parameters include hostname/IP (IPv4 32 bit, IPv6 128 bit) and port (16 bit, 0-65535 with
 * 0-1023 reserved)
 */
public class DemoSocket {

    public static void readFromSocket(String hostname, int port) throws IOException, InterruptedException {
        Socket socket = new Socket(hostname, port);
        boolean autoFlush = true;
        PrintWriter out = new PrintWriter(socket.getOutputStream(), autoFlush);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        // send an HTTP request to the web server
        // out.println("GET /index.jsp HTTP/1.1"); // Method URI Protocol/Version
        out.println("GET / HTTP/1.1"); // Method URI Protocol/Version
        // out.println("Host: http://www.yahoo.com:80"); // with this header readFromSocket returns 404
        out.println("Connection: Close");
        out.println();

        // read the response
        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);

        while (loop) {
            if (in.ready()) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    sb.append((char) i);
                }
                loop = false;
            }
            System.out.println("input is not ready, sleeping 50 ms");
            Thread.sleep(50);
        }

        // display the response to the out console
        System.out.println(sb.toString());
        socket.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        readFromSocket("http://www.yahoo.com", 80);
        // java.net.UnknownHostException: http://www.google.com
        // readFromSocket("http://www.google.com", 80);
        readFromSocket("www.google.com", 80);
    }
}
