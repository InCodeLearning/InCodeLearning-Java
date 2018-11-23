package github.incodelearning.http;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * <ul>
 * <li>Host Name: the name/ip of the machine on which the resource lives.
 * <li>Filename: the pathname to the file on the machine.
 * <li>Port: the port number to which to connect (typically optional).
 * <li>Reference: a reference to a named anchor within a resource that usually identifies a specific location
 * within a file (typically optional).
 * </ul>
 */
public class DemoUrl {
    public static void readFromUrl(URL url) {
    }

    public static URL createFromString(String url) throws MalformedURLException {
        return new URL(url);
    }

    public static void main(String[] args) {

    }
}
