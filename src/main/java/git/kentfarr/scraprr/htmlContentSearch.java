package git.kentfarr.scraprr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class htmlContentSearch {

    public htmlContentSearch(String target, ArrayList<String> urls) throws IOException, InterruptedException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/output/output.txt"));
        target = target.toLowerCase();

            for (String url : urls) {
                try {
                    System.out.println("Searching: " + url);
                    String pageSource = Jsoup.connect(url).get().html();
                    Document doc = Jsoup.parse(pageSource);
                    Elements elements = doc.select("body");
                    String textContent = elements.text().toLowerCase();
                    System.out.println("Content: " + textContent);

                    if (textContent.contains(target)) {
                        System.out.println("Target Found at " + url);
                        writer.write("Target: " + target);
                        writer.newLine();
                        writer.newLine();
                        writer.write("Target url: " + url);
                        writer.newLine();
                        writer.newLine();
                        writer.write("URLS Searched: " + urls);
                        writer.newLine();
                        writer.newLine();
                        writer.write("Content: " + textContent);
                        writer.newLine();
                        writer.newLine();
                        System.out.println("Results Written to output.txt");
                    } else {
                        System.out.println("Target Not Found");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
        }
        writer.close();
    }
}

