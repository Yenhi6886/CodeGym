public class ValidateLopHoc {
    public static boolean isValidClassName(String className) {
        String regex = "^[CAP]\\d{4}[GHIK]$";
        return className.matches(regex);
    }

    public static void main(String[] args) {
        String[] testName = {"C2254G", "A0323K", "M0318G", "P0323A", "C2023H"};
        for (String name : testName) {
            System.out.printf("%s: %s\n", name, isValidClassName(name) ? "Hop le" : "Khong hop le");
        }
    }
}
