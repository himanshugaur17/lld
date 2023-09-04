package jvm.memory;

import java.util.Set;
import java.util.Stack;

import jvm.memory.shared.JavaObject;

public class ThreadStack {
    private Stack<Frame> frames;

}

class Frame {
    private Set<String> localVariables;
    private Set<JavaObject> heapObjectRefs;
}
