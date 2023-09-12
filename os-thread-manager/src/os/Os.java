package os;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import processing.unit.Cpu;
import thread.Instruction;
import thread.Thread;

public class Os {
    private Cpu cpu;
    private Queue<Thread> runnableThreads;
    private Queue<Thread> blockedThreads;
    private Queue<KernelThread> kernelThreadsPool;

    public synchronized void addThread(Thread thread) {
        runnableThreads.add(thread);
    }

    public void startScheduler() {
        while (true) {
            scheduleThread();
            int minNum = Math.min(kernelThreadsPool.size(), blockedThreads.size());
            List<KernelThread> kernelThreads = new ArrayList<>();
            while (minNum > 0) {
                Thread blockedThread = blockedThreads.poll();
                Instruction sysCall = blockedThread.getInstructionSet().poll();
                kernelThreads.add(new KernelThread(true, blockedThread, sysCall));
                minNum--;
            }
            kernelThreads.stream().forEach(KernelThread::scheduleThread);
        }
    }

    public boolean scheduleThread() {
        if (runnableThreads.isEmpty())
            return true;
        Thread thread = runnableThreads.poll();
        boolean val = cpu.scheduleThread(thread);
        if (val == true) {
            if (!thread.getInstructionSet().isEmpty())
                runnableThreads.add(thread);
        } else {
            blockedThreads.add(thread);
        }
        return true;
    }
}
