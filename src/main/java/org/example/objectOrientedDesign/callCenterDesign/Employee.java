package org.example.objectOrientedDesign.callCenterDesign;

public class Employee {
    private String name;
    private boolean isFree;
    EmployeeType role;

    public Employee(String name, EmployeeType role) {
        this.name = name;
        this.isFree = true;
        this.role = role;
    }

    public synchronized boolean isFree(){
        return isFree;
    }

    public synchronized void setFree(boolean free) {
        isFree = free;
    }

    public EmployeeType getRole() {
        return role;
    }
    public void handleCall(Call call){
        setFree(false);

        processCall(call);
    }

    private void processCall(Call call){
        setFree(true);
        CallCenter.getInstance().releaseEmployee(this);

    }
}

enum EmployeeType{
    RESPONDENT,
    MANAGER,
    DIRECTOR,
}
