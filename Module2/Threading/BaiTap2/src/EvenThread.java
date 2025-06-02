public class EvenThread extends Thread{
 @Override
 public void run() {
     for (int i = 2; i <= 10; i+=2) {
         System.out.println("Even: "+i);
         try {
             Thread.sleep(15);
         } catch (InterruptedException e) {
             System.out.println("EvenThread interrupted");
         }
     }
 }
}
