package git.kentfarr.scraprr;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class htmlContentSearch {

    public htmlContentSearch(String target, ArrayList<String> urls) throws IOException, InterruptedException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/output/output.txt"));
        WebDriver driver = new ChromeDriver();
        target = target.toLowerCase();
        synchronized (this) {
            for (String url : urls) {
                wait(2000);
                try {
                    System.out.println("Searching: " + url);
                    driver.get(url);
                    String pageSource = driver.getPageSource();
                    Document doc = Jsoup.parse(pageSource);
                    Elements elements = doc.select("body");
                    String textContent = elements.text().toLowerCase();
                    System.out.println("Content: " + textContent);

                    if (textContent.contains(target)) {
                        System.out.println("Target Found at " + url);
                        writer.write("Target: " + url);
                        writer.newLine();
                        writer.write("URLS Searched: " + urls);
                        writer.newLine();
                        writer.write("Content: " + textContent);
                        writer.newLine();
                        System.out.println("Results Written to output.txt");
                    } else {
                        System.out.println("Target Not Found");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        driver.close();
        writer.close();
        Main.menu();
    }
}







