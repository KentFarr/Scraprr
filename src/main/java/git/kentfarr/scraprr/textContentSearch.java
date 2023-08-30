package git.kentfarr.scraprr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class textContentSearch {

    // This method is used to search the text content of a website
    public textContentSearch(String target, ArrayList<String> urls) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/output/output.txt"));
        String targetLower = target.toLowerCase();
        for (int i = 0; i < urls.size(); i++) {
            System.out.println(urls.size());
            try {
                System.out.println("Searching: " + urls.get(i));
                Document doc = Jsoup.connect(urls.get(i)).get();

                String textContent = doc.wholeText().toLowerCase();
                if (textContent.contains(targetLower)) {
                    System.out.println("Target Found");
                    writer.write("Target: " + targetLower);
                    writer.newLine();
                    writer.write("URLS Searched: " + urls);
                    writer.newLine();
                    writer.write("Content: " + textContent);
                    writer.newLine();
                    writer.write("Social Found: " + urls.get(i) + " " + targetLower);
                    writer.newLine();
                    System.out.println("Results Written to output.txt");
                    System.out.println("Social Found: " + urls.get(i) + " " + targetLower);
                } else {
                    System.out.println("Target Not Found");
                    continue;
                }
                writer.close();

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        Main.menu();
    }
}