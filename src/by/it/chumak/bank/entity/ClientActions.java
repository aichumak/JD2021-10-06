package by.it.chumak.bank.entity;

import by.it.chumak.bank.helper.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class ClientActions {

    public static List<Enum> getActions(){
        List<Enum> actionList = getActionList();
        List<Enum> clientActionList = new ArrayList<>();
        int countActions = RandomGenerator.get(1, 5);

        for (int i = 0; i < countActions; i++) {
            clientActionList.add(actionList.get(RandomGenerator.get(1, 5)));
        }

        return clientActionList;
    }

    private static List<Enum> getActionList() {
        List<Enum> actionList = new ArrayList<>();
        actionList.add(ClientActionsEnums.Exchange);
        actionList.add(ClientActionsEnums.Pay);
        actionList.add(ClientActionsEnums.TopUp);
        actionList.add(ClientActionsEnums.Transfer);
        actionList.add(ClientActionsEnums.Withdraw);
        return actionList;
    }

}
