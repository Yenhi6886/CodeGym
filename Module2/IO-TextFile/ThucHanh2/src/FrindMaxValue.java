import java.util.List;

public class FrindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("ThucHanh2\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("ThucHanh2\\max.txt", maxValue);
    }
}
