package Assignment2;

import java.util.Queue;
import java.util.Stack;

public abstract class BigSystem {
    protected Queue<String> inBoxQueue;
    protected Queue<String> outBoxQueue;
    protected Stack<String> processingStack;
    protected BigSystem connectedSystem;

    public void connect(BigSystem system) {
        this.connectedSystem = system;
        system.connectedSystem = this;
        System.out.println(this.getClass().getSimpleName() + " is connecting to " + system.getClass().getSimpleName());
        System.out.println(system.getClass().getSimpleName() + " is connecting to " + this.getClass().getSimpleName());
    }

    public void disconnect() {
        this.connectedSystem = null;
    }
    public Queue<String> getOutBoxQueue() {
        return outBoxQueue;
    }
    public Queue<String> getInBoxQueue() {
        return inBoxQueue;
    }


    public abstract void sendMessage(String message);

    public abstract void receiveMessage();

    public abstract void readOutboxQueue();

    public abstract void readInboxQueue();

    public abstract void processMessages();

    protected void sendRequestToReceive() {
    }
}
