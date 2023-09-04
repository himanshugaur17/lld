import java.util.ArrayList;
import java.util.List;

import jvm.memory.ThreadStack;
import jvm.memory.shared.ProcessHeap;

public class Memory {
    private List<ThreadStack> threadStacks;
    private jvm.memory.shared.ProcessHeap processHeap;

    public Memory() {
        System.out.println("allocating space for heap and stack");
        this.threadStacks = new ArrayList<>();
        this.processHeap = new ProcessHeap();
    }

}
