package os;

import thread.Instruction;
import thread.Thread;

public class KernelThread {
    private boolean isOccupied;
    private Thread userThread;
    private Instruction instruction;

    public KernelThread(boolean isOccupied, Thread userThread, Instruction instruction) {
        this.isOccupied = isOccupied;
        this.userThread = userThread;
        this.instruction = instruction;
    }

    public boolean scheduleThread() {
        return 
    }
}
