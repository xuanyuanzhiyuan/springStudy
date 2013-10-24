package java7study.concurrency.blockingqueue;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * User: jinyanhua
 * Date: 13-10-24
 * Time: 上午10:21
 */
public class WorkSpace {
    private final BlockingQueue<WorkUnit> workUnits = new LinkedBlockingQueue<WorkUnit>(200);
    private final List<Commander> commanders;
    private final List<Worker> workers;
    private Executor commandersExecuter;
    private Executor workerExecuter;

    public WorkSpace() {
        //init executor
        this.commandersExecuter = Executors.newScheduledThreadPool(20);
        this.workerExecuter = Executors.newFixedThreadPool(20);
        //init commanders
        Commander commander = new Commander(workUnits,"officer");
        this.commanders = Lists.newArrayList(commander);
        this.commandersExecuter.execute(commander);
        //init workers
        this.workers = new ArrayList<Worker>(10);
        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker(workUnits,"No."+i);
            this.workers.add(worker);
            this.workerExecuter.execute(worker);
        }
    }

    public static void main(String[] args) {
        WorkSpace ws = new WorkSpace();
    }
}
