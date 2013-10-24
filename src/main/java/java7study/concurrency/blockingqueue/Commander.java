package java7study.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * User: jinyanhua
 * Date: 13-10-24
 * Time: 上午10:30
 */
public class Commander implements Runnable{
    private final BlockingQueue<WorkUnit> workUnits;
    private final String name;

    public Commander(BlockingQueue<WorkUnit> workUnits, String name) {
        this.workUnits = workUnits;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            WorkUnit wu = new WorkUnit(""+System.currentTimeMillis());
            try {
                System.out.println("Commander "+ this.name +" give a order.");
                workUnits.offer(wu,100, TimeUnit.MILLISECONDS);
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
