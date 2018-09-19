import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Calculates the word count of a webpage in the form of a String
     *
     * @param pageAsString the contents of the web page in a string
     * @return the number of words
     */
    public static int wordCount(final String pageAsString) {
        String[] split = pageAsString.split("\\s+");
        return split.length;
    }

    /**
     * Counts the number of times a specific word shows up on a web page
     *
     * @param pageAsString the webpage as a string
     * @param word the word in question
     * @return the number of instances of the specific word
     */
    public static int specificWordCount(final String pageAsString, final String word) {
        String wordInQuestion = word.toLowerCase();
        String lowercasePageAsString = pageAsString.toLowerCase();
        String[] split = pageAsString.split("\\s+");
        int wordCount = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(wordInQuestion)) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public static void main(String[] unused) {
        String urlString = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(wordCount(urlString));
        System.out.println(specificWordCount(urlString, "prince"));
    }
}
