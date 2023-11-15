package com.nrb.todo.model;

public enum Priority {
    VERY_IMPORTANT(1, "Very important"),
    IMPORTANT(2, "Important"),
    CAN_WAIT(3, "Can wait");
    private int priority;
    private String desc;
    Priority(int priority, String desc) {
        this.priority = priority;
        this.desc = desc;
    }
    public int getPriority() {
        return priority;
    }
    public String getDesc() {
        return desc;
    }
}
