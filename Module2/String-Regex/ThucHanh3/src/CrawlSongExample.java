import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://vnexpress.net/tin-tuc-24h");
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            sc.close();
            content = content.replaceAll("\\n+","");

            Pattern p = Pattern.compile("<a[^>]*?title=\"([^\"]{10,120})\"[^>]*?>");
            Matcher m = p.matcher(content);
            // In ra các tiêu đề
            int count = 0;
            while (m.find()) {
                System.out.println(++count + ". " + m.group(1));
                if (count > 20) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// <a[^>]*?title=\"([^\"]{10,120})"[^>]*?>