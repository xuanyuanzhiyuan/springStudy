package java7study.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * User: jinyanhua
 * Date: 13-10-24
 * Time: 上午10:30
 */
public class Worker implements Runnable{
    private final BlockingQueue<WorkUnit> workUnits;
    private final String name;

    public Worker(BlockingQueue<WorkUnit> workUnits, String name) {
        this.workUnits = workUnits;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            try {
                WorkUnit myjob = workUnits.take();
                System.out.println("Worker "+name+"do his job:"+myjob.getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
