package Unit10_Collection_2;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyEample {
   private static void addData(List list) throws InterruptedException {
       while (true){
           int random = (int) (Math.random()*100);
           list.add(random);
           System.out.println("add new data :"+random);
           Thread.sleep(1022);
           Thread.onSpinWait();

       }
   }
    private static void printData(List list) throws InterruptedException{
       while (true){
           try {
               System.out.println("=============");
               list.forEach(value->{
                   System.out.println("value ="+value);
                   try {
                       Thread.sleep(90);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               });
           }catch (Exception e){
                e.printStackTrace();

           }
       }
    }
    public static void main(String[] args) {
        List list = new ArrayList<>();
        ConcurrencyEample c= new ConcurrencyEample();
        new Thread(()-> {
            try {
                addData(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                printData(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
