package git.kentfarr.scraprr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class textContentSearch {

    // This method is used to search the text content of a website
    public textContentSearch(String target, ArrayList<String> urls) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/output/output.txt"));
            String targetLower = target.toLowerCase();

            for (int i = 0; i < urls.size(); i++) {
                Document doc = Jsoup.connect(urls.get(i)).get();
                String textContent = doc.text().toLowerCase();
                if (textContent.contains(targetLower)) {
                    System.out.println("Target Found");
                    writer.write("Target Found");
                    writer.write("Target: " + targetLower);
                    writer.write("URLS: " + urls);
                    writer.write("Content: " + textContent);
                    System.out.println("Results Written to output.txt");
                } else {
                    System.out.println("Target Not Found");
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

