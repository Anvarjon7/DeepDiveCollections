package org.example.objectOrientedDesign.callCenterDesign;

public class Call {

    private String callerId;
    private int duration;
    private Employee assignedEmployee;

    public Call(String callerId, int duration) {
        this.callerId = callerId;
        this.duration = duration;
    }

    public void assignEmployee(Employee employee) {
        this.assignedEmployee = employee;
        employee.handleCall(this);
    }
}
