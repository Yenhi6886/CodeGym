public class Main {
    static int[] list =  {1, 2, 4, 3};

    public static void bubble(int[] list) {
        boolean flag = true;

        for (int i = 1; i < list.length && flag; i++) {
            flag = false;

            for (int j = 0; j < list.length - 1; j++) {
                if(list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;

                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        bubble(list);
        System.out.println();
        for(int k = 0; k < list.length; k++) {
            System.out.print(list[k]+" ");
        }
    }
}
