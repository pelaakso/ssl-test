import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class CopyUrlToFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(help());
            System.exit(1);
        }
        
        download(args[0], args[1]);
    }

    private static void download(String urlString, String file) {
        try {
            URL url = new URL(urlString);
            File target = new File(file);

            FileUtils.copyURLToFile(url, target, 10000, 30000);

            System.out.println(url + " downloaded to " + target);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String help() {
        return "komento urli tiedosto";
    }
}
