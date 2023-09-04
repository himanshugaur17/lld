package jvm.memory.shared;

import java.util.Set;

public class JavaObject {
    private int referenceCount;
    private Set<JavaObject> heapObjectRefs;

    public JavaObject(int referenceCount) {
        this.referenceCount = referenceCount;
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(int referenceCount) {
        this.referenceCount = referenceCount;
    }

    public Set<JavaObject> getHeapObjectRefs() {
        return heapObjectRefs;
    }

    public void setHeapObjectRefs(Set<JavaObject> heapObjectRefs) {
        this.heapObjectRefs = heapObjectRefs;
    }

}
