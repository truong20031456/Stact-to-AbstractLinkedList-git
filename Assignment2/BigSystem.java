package Assignment2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BigSystem {

    protected Queue<String> inBoxQueue;
    protected Queue<String> outBoxQueue;
    protected Stack<String> processingStack;
    protected BigSystem connectedSystem;

    public Queue<String> getOutBoxQueue() {
        return outBoxQueue;
    }

    public Queue<String> getInBoxQueue() {
        return inBoxQueue;
    }

    public Stack<String> getProcessingStack() {
        return processingStack;
    }

    private boolean connected = false;

    public BigSystem() {
        inBoxQueue = new LinkedList<>();
        outBoxQueue = new LinkedList<>();
        processingStack = new Stack<>();
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void connect(BigSystem system) {
        if (this.getName().equals("systemA") && system.getName().equals("systemB")) {
            this.connectedSystem = system;
            system.connectedSystem = this;

            System.out.println(this.getClass().getSimpleName() + " '" + this.getName() + "' is connecting to " +
                    system.getClass().getSimpleName() + " '" + system.getName() + "'");
            connected = true;
        } else if (this.getName().equals("systemB") && system.getName().equals("systemA")) {
            this.connectedSystem = system;
            system.connectedSystem = this;

            System.out.println(this.getClass().getSimpleName() + " '" + this.getName() + "' is connecting to " +
                    system.getClass().getSimpleName() + " '" + system.getName() + "'");
            connected = true;
        }
    }

    public void sendMessage(String message) {
        try {
            if (connectedSystem == null) {
                throw new IllegalStateException("Error: Not connected to any system.");
            }

            if (connected) {
                if (message.isEmpty()) {
                    throw new IllegalArgumentException("Error: Message is empty.");
                }

                if (message.length() > 250) {
                    System.out.println("Error: Message is too long. Truncating message.");
                    int chunkSize = 250;
                    for (int i = 0; i < message.length(); i += chunkSize) {
                        int end = Math.min(message.length(), i + chunkSize);
                        String chunk = message.substring(i, end);
                        getOutBoxQueue().offer(chunk);
                    }
                } else {
                    getOutBoxQueue().offer(message);
                }

                System.out.println("Message sent from " + this.getClass().getSimpleName() + " '" + this.getName() + "' to " +
                        connectedSystem.getClass().getSimpleName() + " '" + connectedSystem.getName() + "'");
            } else {
                System.out.println("Error: Not connected to the intended system.");
            }
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public void readOutboxQueue() {
        System.out.println("Outgoing Messages from " + this.getClass().getSimpleName() + " '" + this.getName() + "':");
        if (getOutBoxQueue().isEmpty()) {
            System.out.println("Outbox Queue is empty.");
        } else {
            for (String message : getOutBoxQueue()) {
                System.out.println(message);
            }
        }
    }

    public void readInboxQueue() {
        System.out.println("Incoming Messages to " + this.getClass().getSimpleName() + " '" + this.getName() + "':");
        if (getInBoxQueue().isEmpty()) {
            System.out.println("Inbox Queue is empty.");
        } else {
            for (String message : getInBoxQueue()) {
                System.out.println(message);
            }
        }
    }


    public void sendRequestToReceive() {
        if (!isConnected()) {
            System.out.println("Error: Connection not established.");
            return;
        }

        if (connectedSystem == null) {
            System.out.println("Error: No connected system found.");
            return;
        }

        Queue<String> connectedOutBoxQueue = connectedSystem.getOutBoxQueue();

        if (connectedOutBoxQueue.isEmpty()) {
            System.out.println("System's outboxQueue is empty.");
        } else {
            while (!connectedOutBoxQueue.isEmpty()) {
                String message = connectedOutBoxQueue.poll();
                getInBoxQueue().offer(message);
            }
            System.out.println("Received messages from connected system.");
        }
    }

    public void receiveMessageFromSystem(BigSystem connectedSystem) {
        if (connectedSystem == null) {
            System.out.println("Error: No connected system provided.");
            return;
        }

        if (connectedSystem.isConnected()) {
            connectedSystem.sendRequestToReceive();
            readInboxQueue();
            System.out.println("Received messages from " + connectedSystem.getClass().getSimpleName());
        } else {
            System.out.println("Error: Connection not established with the provided system.");
        }
    }




    public void processMessages() {
        try {
            if (connectedSystem == null) {
                throw new IllegalStateException("Error: Connection not established.");
            }
            while (!getInBoxQueue().isEmpty()) {
                String message = getInBoxQueue().poll();
                getProcessingStack().push(message);
            }

            while (!getProcessingStack().isEmpty()) {
                String poppedMessage = getProcessingStack().pop();
                System.out.println("Message popped from processingStack: " + poppedMessage);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }


    public void disconnect(BigSystem systemToDisconnect) {
        if (this.connectedSystem == null || systemToDisconnect.connectedSystem == null) {
            System.out.println("Both systems are already disconnected.");
        } else if (this.connectedSystem == systemToDisconnect && systemToDisconnect.connectedSystem == this) {
            this.connectedSystem = null;
            systemToDisconnect.connectedSystem = null;

            System.out.println("Disconnected " + systemToDisconnect.getClass().getSimpleName() + " '" + systemToDisconnect.getName() +
                    "' from " + this.getClass().getSimpleName() + " '" + this.getName() + "'");
        } else {
            System.out.println("Invalid disconnection. Please choose the correct systems to disconnect.");
        }
    }

    public boolean isConnected() {
        return connected;
    }
}
