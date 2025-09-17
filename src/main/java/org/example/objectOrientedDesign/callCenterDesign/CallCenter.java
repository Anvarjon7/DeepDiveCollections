package org.example.objectOrientedDesign.callCenterDesign;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    private ConcurrentLinkedQueue<Employee> respondentQueue = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<Employee> managerQueue = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<Employee> directorQueue = new ConcurrentLinkedQueue<>();

    private static CallCenter instance = new CallCenter();

    public CallCenter() {
    }

    public static CallCenter getInstance() {
        return instance;
    }

    public void addEmployee(Employee employee) {
        switch (employee.getRole()) {
            case RESPONDENT -> respondentQueue.offer(employee);
            case MANAGER -> managerQueue.offer(employee);
            case DIRECTOR -> directorQueue.offer(employee);
        }
    }

    public Employee getAvailableEmployee() {
        Employee e = respondentQueue.poll();
        if (e != null) return e;
        e = managerQueue.poll();
        if (e != null) return e;
        return directorQueue.poll();
    }

    public void releaseEmployee(Employee e) {
        e.setFree(true);

        addEmployee(e);
    }

    public void dispatchCall(Call call) {
        Employee e = getAvailableEmployee();
        if (e != null) {
            call.assignEmployee(e);
        }else {
            System.out.println("All employees are busy.Call is waiting...");
        }

    }
}
