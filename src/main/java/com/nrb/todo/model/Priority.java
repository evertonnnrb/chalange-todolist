package com.nrb.todo.model;

public enum Priority {
    VERY_IMPORTANT(1),
    IMPORTANT(2),
    CAN_WAIT(3);

    private int priority;

    private Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

}
