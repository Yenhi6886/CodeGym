import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String urlStr =  "https://dantri.com.vn/the-gioi.htm";
        try {
            URL url = new URL(urlStr);
            Scanner sc = new Scanner(new InputStreamReader(url.openStream(),"UTF-8"));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            sc.close();

            content = content.replaceAll("\\n+","");

            String regex = "<a class=\"dt-text-black-mine\"[^>]*>(.*?)</a>";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(content);
            System.out.println("Danh sach tieu de ban tin");
            int count = 0;
            while (matcher.find()) {
                String title = matcher.group(1).trim();
                System.out.println(++count+" : "+title);
                if (count>=20) break;
            }
            if (count ==0) {
                System.out.println("Khong co the nao ca");
            }
        } catch (IOException e) {
            System.err.println("Loi "+e.getMessage());
        }
    }
}