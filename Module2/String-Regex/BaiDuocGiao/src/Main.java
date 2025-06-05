import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String hv = "HV-0002";
        String nv = "NV-0001";
        String book = "BOOK-0001";

        Pattern p = Pattern.compile("^HV-[0-9]{4}$");
        Matcher m = p.matcher(hv);
        System.out.println(m.matches());

        Pattern p2 = Pattern.compile("^NV-[0-9]{4}$");
        Matcher m2 = p2.matcher(nv);
        System.out.println(m2.matches());

        Pattern p3 = Pattern.compile("^BOOK-[0-9]{4}$");
        Matcher m3 = p3.matcher(book);
        System.out.println(m3.matches());
    }
}