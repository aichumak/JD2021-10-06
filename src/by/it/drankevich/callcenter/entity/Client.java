package by.it.drankevich.callcenter.entity;

public class Client {

    private final String name;

    public Client(int i) {
        this.name="Client № "+i;
    }

     private boolean flagWaiting;

    public boolean isFlagWaiting() {
        return flagWaiting;
    }

    public void setFlagWaiting(boolean flagWaiting) {
        this.flagWaiting = flagWaiting;
    }

    @Override
    public String toString() {
        return name;
    }

    public Object getMonitor() {
        return this;
    }
}
