import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            System.out.println("Reading file: " + file.getAbsolutePath());

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
            e.printStackTrace();
        }
        return numbers;
    }
    public void writeFile(String filePath, int max) {
        try{
            FileWriter writer = new FileWriter(filePath,true);
            BufferedWriter bufferedReader = new BufferedWriter(writer);
            bufferedReader.write("Max: "+max);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
