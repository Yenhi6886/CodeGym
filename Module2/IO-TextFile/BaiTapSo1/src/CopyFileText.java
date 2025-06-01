import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tập tin nguồn: ");
        String sourcePath = sc.nextLine().trim();
        System.out.println("Nhập vào một tập tin đích: ");
        String targetPath = sc.nextLine().trim();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        //Kiểm tra file nguồn
        if(!sourceFile.exists() && !sourceFile.isFile()){
            System.err.println("File nguồn không tồn tại hoạc khong phải file hợp lệ!");
            return;
        }

        //Kiểm tra file đích
        if(targetFile.exists()) {
            System.out.println("File đích đã tồn tại.Ghi đè? (y/n): ");
            String choice = sc.nextLine().trim().toLowerCase();
            if(!choice.equals("y")) {
                System.out.println("Đã hủy thao tác sao chép");
                return;
            }
        }
        //Thuc hien sao chep va đếm kí tự
        int charCount = 0;
        try (
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(targetFile);
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            int ch;
            while ((ch = br.read())!= -1) {
                bw.write(ch);
                charCount++;
            }
            //flush và close tự động qua try-with-resources
            System.out.println("Đã sao chép thành công "+charCount+" kí tự");
        } catch (IOException e) {
            System.err.println("Lỗi I/O trong quá trình sao chép: "+e.getMessage());
        }
    }
}
