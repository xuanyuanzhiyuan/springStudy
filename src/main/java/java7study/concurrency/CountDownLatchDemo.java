package java7study.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * User: jinyanhua
 * Date: 13-10-25
 * Time: 下午2:51
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.showCountDownLatch();
    }

    public void showCountDownLatch(){
        CountDownLatch latch  = new CountDownLatch(1);
        Executor executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(new Work(i,latch));
        }
        System.out.println("read to go......");
        latch.countDown();
    }

    class Work implements Runnable{
        private int number;
        private CountDownLatch latch;

        Work(int number, CountDownLatch latch) {
            this.number = number;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("No." + this.number + "start to work");
            long workTime = (long) (Math.random()*1000);
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("No."+this.number+" finished work");
        }
    }
}
