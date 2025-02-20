package model;

import java.util.concurrent.atomic.*;

public class Student {
    private String firstName;
    private String lastName;
    private String id;

    private Student(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.id = builder.id;
    }

    public final static class Builder {
        private String firstName;
        private String lastName;
        private String id;
        private static AtomicReference<Builder> builderInstance;

        private Builder() {

        }

        public static Builder copyBuilder(String firstName, String lastName, String id) {
            Builder builder = new Builder();
            builder.firstName = firstName;
            builder.id = id;
            builder.lastName = lastName;
        }

        public static Builder newBuilder() {
            if (builderInstance == null) {
                synchronized (Builder.class) {
                    if (builderInstance == null)
                        builderInstance = new AtomicReference<>(new Builder());
                }
            }
            return builderInstance.get();

        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

        public Student safeBuild(Builder shouldMatchThisBuilder){
            Builder currBuilderValue=builderInstance.get();
            if(builderInstance.compareAndSet(shouldMatchThisBuilder, currBuilderValue)){
                synchronized(builderInstance){
                    
                }
            }
        }
    }
}
