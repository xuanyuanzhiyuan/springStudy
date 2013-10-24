package java7study.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: jinyanhua
 * Date: 13-10-23
 * Time: 下午5:14
 */
public class ConcurrencyDemo {
    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ConcurrencyDemo demo = new ConcurrencyDemo();
        demo.showHowToUseLock();
        System.out.println("Finish...");
    }

    public void showHowToUseLock(){
        Thread t1 = new Thread(new WorkUnit());
        Thread t2 = new Thread(new WorkUnit());
        t1.start();
        t2.start();
    }

    private void useLockReplaceSynchronized(){
        boolean isGetLock = lock.tryLock();
        try{
            lock.lock();
            System.out.println("do business logic here ");
        }finally {
            lock.unlock();
        }
    }

    private class WorkUnit implements Runnable{

        @Override
        public void run() {
            ConcurrencyDemo.this.useLockReplaceSynchronized();
        }
    }
}
