package os;

import java.util.Queue;
import java.util.Set;

import processing.unit.Cpu;
import thread.Thread;

public class Os {
    private Cpu cpu;
    private Queue<Thread> runnableThreads;
    private Set<Thread> blockedThreads;

    public synchronized void addThread(Thread thread) {
        runnableThreads.add(thread);
    }

    public boolean scheduleThread() {
        if (runnableThreads.isEmpty())
            return true;
        Thread thread = runnableThreads.peek();
        
    }
}
