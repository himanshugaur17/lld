package thread;

public class Instruction {
    private boolean isSystemCallInstruction;
    private String instructionDesc;
    private Integer instructionId;

    @Override
    public String toString() {
        return "Instruction [isSystemCallInstruction=" + isSystemCallInstruction + ", instructionDesc="
                + instructionDesc + ", instructionId=" + instructionId + "]";
    }

    public Instruction(boolean isSystemCallInstruction, String instructionDesc, Integer instructionId) {
        this.isSystemCallInstruction = isSystemCallInstruction;
        this.instructionDesc = instructionDesc;
        this.instructionId = instructionId;
    }

    public boolean runInstruction() {
        if (this.isSystemCallInstruction) {
            /*
             * handle system call, switch to kernel mode
             * and have to block the calling thread
             */
            return true;
        }
        try {
            /*
             * Introducing sleep interval to simulate
             * time taken by the instruction
             */
            java.lang.Thread.sleep(10000);

        } catch (InterruptedException e) {
            return false;
        }
        System.out.println(this.toString() + " successfully run");
        return true;
    }
}