package jvm.memory;

import java.util.Set;
import java.util.Stack;

import jvm.memory.shared.JavaObject;

public class ThreadStack {
    private Stack<Frame> frames;

    public void popFrame() {
        Frame frameToBePopped = frames.peek();
        /*
         * Here we will do the garabge
         * collection by updating the references to an object in heap
         */
        frames.pop();
    }

}

class Frame {
    private Set<String> localVariables;
    private Set<JavaObject> heapObjectRefs;
}
