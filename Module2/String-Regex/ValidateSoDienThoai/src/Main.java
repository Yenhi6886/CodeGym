public class Main {
    public static boolean soDienThoaiHopLe(String phoneNumber) {
        String regex = "^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$";
        if(phoneNumber == null) return false;
        return  phoneNumber.matches(regex);
    }

    public static void main(String[] args) {
        String[] testCase = {
                "(84)-(0946868678)",
                "(a4)-(0946868678)",
                "(84)-(2946868678)",
                "(84)-(06868678)",
                "(84)-(29464t8678)",
        };
        for (String test : testCase) {
            System.out.printf("Kiểm tra %-20s : %s\n", test, soDienThoaiHopLe(test));
        }
    }
}