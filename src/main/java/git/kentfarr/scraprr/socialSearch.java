package git.kentfarr.scraprr;

import java.util.ArrayList;
import java.util.Scanner;

public class socialSearch  {
    public socialSearch(String username) {
        String[] socialMediaSites = {"https://www.tiktok.com/@", "https://www.instagram.com/@",
                "https://www.facebook.com/@", "https://www.twitter.com/@", "http://us.match.com/profile/",
                "https://gotinder.com/@", "https://kick.com/", "https://www.deviantart.com/",
                "https://www.pornhub.com/users/", "https://www.youporn.com/", "https://onlyfans.com/",
                "https://chaturbate.com/"}; // Add more social media sites here
        try {
            ArrayList<String> urls = new ArrayList<String>();
            for (int i = 0; i < socialMediaSites.length; i++) {
                urls.add(socialMediaSites[i] + (username));
            }
            System.out.println("do you want to save the results to a file? (y/n)");
            Scanner sc = new Scanner(System.in);
            String response = String.valueOf(sc.nextLine());
            if (response.equals("y")) {
                new htmlContentSearch(username, urls);
            } else {
                Main.menu(sc);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
