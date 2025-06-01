import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("countries.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                String id = tokens[0].trim().replace("\"","");
                String name = tokens[1].trim().replace("\"", "");
                String code = tokens[2].trim().replace("\"", "");

                Country country = new Country(name,id,code);
                countries.add(country);
            }
        } catch (IOException e) {
            System.err.println("Loi khi doc file: "+e.getMessage());
            return;
        }
        for(Country country : countries) {
            System.out.println(country);
        }
    }
}
