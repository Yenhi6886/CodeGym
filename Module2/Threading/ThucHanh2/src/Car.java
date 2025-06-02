import java.util.Random;

public class Car implements Runnable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance = 0; //Biến này giữ quãng đường xe đã đi được.Khởi tạo điểm start (km ban đầu)
        //Khoi tạo time bat dau cuoc dua
        long startTime = System.currentTimeMillis();
        // Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
        while (runDistance < Main.DISTANCE) {
            try {
                //Random toc do km/h
                int speed = (new Random()).nextInt(20);
                //tinh khoang cach da di duoc
                runDistance += speed;
                //Ve duong da di cua xe
                String log = "|";
                int percentTravel = (runDistance * 100) / Main.DISTANCE; //Tính phần trăm quãng đường đã đi.
                for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
                    if (percentTravel >= i + Main.STEP) {
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log+="|";
                System.out.println("Car"+this.name+": "+log+" "+Math.min(Main.DISTANCE,runDistance)+ "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car"+this.name+" broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car"+this.name+": "+(endTime - startTime)/1000+"s");
    }
}
