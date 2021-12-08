package by.it.drankevich.callcenter;

import by.it.drankevich.callcenter.entity.CallCenter;
import by.it.drankevich.callcenter.entity.Queue;
import by.it.drankevich.callcenter.entity.WorkingDayPlan;
import by.it.drankevich.callcenter.helper.Timeout;
import by.it.drankevich.callcenter.servise.CallCenterWorker;

public class Runner {
    public static void main(String[] args) {


        Queue queue = new Queue();
        WorkingDayPlan workingDayPlan = new WorkingDayPlan(50);
        CallCenter callCenter = new CallCenter(queue, workingDayPlan);
        CallCenterWorker callCenterWorker= new CallCenterWorker(callCenter);
        callCenterWorker.start();

    }
}
