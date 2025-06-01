import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

        } finally {
            input.close();
            output.close();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập nguồn: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Nhập đích: ");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try{
        copyFileUsingJava7Files(sourceFile,destFile);
            System.out.println("Đã sao chép thanh công");
        } catch (IOException e) {
            System.out.println("Không thể sao chép");
            System.out.println(e.getMessage());
        }
    }

}
//copyFileUsingJava7Files
//copyFileUsingStream