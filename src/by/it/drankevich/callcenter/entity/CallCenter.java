package by.it.drankevich.callcenter.entity;

public class CallCenter {

    private final Queue queue;
    private final WorkingDayPlan workingDayPlan;

    public CallCenter(Queue queue, WorkingDayPlan workingDayPlan) {
        this.workingDayPlan=workingDayPlan;
        this.queue=queue;

    }

    public Queue getQueue() {
        return queue;
    }

    public WorkingDayPlan getWorkingDayPlan() {
        return workingDayPlan;
    }
}
