//import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class ReadUrl {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(help());
            System.exit(1);
        }
        
        readFile(args[0]);
    }

    private static void readFile(String urlString) {
        try {
            openStreamWithHeaders(urlString, 10000, null);

            System.out.println(urlString + " opened");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static InputStream openStreamWithHeaders(String urlString, int timeout, Map<String, String> headers) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();

        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);

        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        connection.connect();

        return new BufferedInputStream(connection.getInputStream());
    }

    private static String help() {
        return "komento urli";
    }
}
