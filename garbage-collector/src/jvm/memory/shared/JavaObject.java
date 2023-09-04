package jvm.memory.shared;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class JavaObject {
    private int referenceCount;
    private Set<JavaObject> heapObjectRefs = new ConcurrentSkipListSet<>();

    public JavaObject(int referenceCount) {
        this.referenceCount = referenceCount;
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public synchronized int increaseReferenceCount() {
        return ++this.referenceCount;
    }

    public synchronized int decreaseReferenceCount() {
        return --this.referenceCount;
    }
    /*
     * There won't be any deleteObjectFromHeap method, because until
     * this object exists, the reference will always be there.
     */

    public Set<JavaObject> addObjectToHeap(JavaObject obj) {
        heapObjectRefs.add(obj);
        return heapObjectRefs;
    }

    public void setHeapObjectRefs(Set<JavaObject> heapObjectRefs) {
        this.heapObjectRefs = heapObjectRefs;
    }

}
