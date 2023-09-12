package processing.unit;

import java.util.Random;

import thread.Instruction;

/*
 * Assuming single core cpu
 * for the simplicity
 */
public class Cpu implements CpuInterface {
    private thread.Thread currRunningThread;

    @Override
    public boolean scheduleThread(thread.Thread thread) {
        this.currRunningThread = thread;
        int switchContextAfter = new Random().nextInt(10);
        while (!thread.getInstructionSet().isEmpty() && switchContextAfter > 0) {
            Instruction instruction = thread.getInstructionSet().poll();
            runInstruction(instruction);
            switchContextAfter--;
        }
        return true;
    }

    public boolean isCpuIdle() {
        return currRunningThread == null;
    }

    private boolean runInstruction(Instruction instruction) {
        return instruction.runInstruction();
    }
}
