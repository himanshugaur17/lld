package thread;

import java.util.Queue;
import java.util.Random;
import java.lang.*;

public abstract class Thread {

    private Integer threadId;
    private ThreadState ThreadState;
    private Queue<Instruction> instructionSet;

    public Integer getThreadId() {
        return threadId;
    }

    public ThreadState getThreadState() {
        return ThreadState;
    }

    public Queue<Instruction> getInstructionSet() {
        return instructionSet;
    }

}