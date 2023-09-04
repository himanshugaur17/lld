package jvm.memory.shared;

import java.util.ArrayList;
import java.util.List;

public class ProcessHeap {
    private List<JavaObject> javaObjects;

    public List<JavaObject> getJavaObjects() {
        return javaObjects;
    }

    public ProcessHeap() {
        this.javaObjects = new ArrayList<>();
    }

    public void setJavaObjects(List<JavaObject> javaObjects) {
        this.javaObjects = javaObjects;
    }
}
