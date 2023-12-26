package Assignment2;

import java.util.Queue;
import java.util.Stack;

public class BigSystem {

    protected Queue<String> inBoxQueue;
    protected Queue<String> outBoxQueue;
    protected Stack<String> processingStack;
    protected BigSystem connectedSystem;
    private  boolean connected= false;
    public BigSystem(Queue<String> inBoxQueue, Queue<String> outBoxQueue, Stack<String> processingStack) {
        this.inBoxQueue = inBoxQueue;
        this.outBoxQueue =outBoxQueue;
        this.processingStack=processingStack;
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

            // Printing connection information only for systemA connecting to systemB
            System.out.println(this.getClass().getSimpleName() + " '" + this.getName() + "' is connecting to " +
                    system.getClass().getSimpleName() + " '" + system.getName() + "'");
        } else if (this.getName().equals("systemB") && system.getName().equals("systemA")) {
            this.connectedSystem = system;
            system.connectedSystem = this;
            // Do nothing or handle the connection differently if systemB connects to systemA
            // Optionally print a message indicating that the connection is not supported
            System.out.println(this.getClass().getSimpleName() + " '" + this.getName() + "' is connecting to " +
                    system.getClass().getSimpleName() + " '" + system.getName() + "'");
        }
    }



    // Existing code...




    public Queue<String> getOutBoxQueue() {
        return outBoxQueue;
    }
    public Queue<String> getInBoxQueue() {
        return inBoxQueue;
    }
    public Stack<String> getProcessingStack(){
        return processingStack;
    }


    public void sendMessage(String message) {
        try {
            if (connectedSystem == null) {
                throw new IllegalStateException("Error: Not connected to any system.");
            }

            if (this == connectedSystem) {
                if (message.isEmpty()) {
                    throw new IllegalArgumentException("Error: Message is empty.");
                }
                if (message.length() > 250) {
                    System.out.println("Error: Message is too long. Truncating message.");
                    int chunkSize = 250;
                    for (int i = 0; i < message.length(); i += chunkSize) {
                        int end = Math.min(message.length(), i + chunkSize);
                        String chunk = message.substring(i, end);
                        outBoxQueue.offer(chunk);
                    }
                } else {
                    outBoxQueue.offer(message);
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

    public void receiveMessageFromSystem(BigSystem connectedSystem) {
        Queue<String> connectedInBoxQueue = connectedSystem.getInBoxQueue();
        if (!connectedInBoxQueue.isEmpty()) {
            while (!connectedInBoxQueue.isEmpty()) {
                String message = connectedInBoxQueue.poll();
                this.inBoxQueue.offer(message);
            }
            System.out.println("Received messages from " + connectedSystem.getClass().getSimpleName());
        } else {
            System.out.println(connectedSystem.getClass().getSimpleName() + "'s Inbox Queue is empty.");
        }
    }

    public void sendRequestToReceive() {
        if (isConnected()) {
            if (connectedSystem.getOutBoxQueue().isEmpty()) {
                System.out.println("System's outboxQueue is empty.");
            } else {
                inBoxQueue.offer(connectedSystem.getOutBoxQueue().poll());
                System.out.println("Received messages from System.");
            }
        } else {
            System.out.println("Error: Connection not established with SystemA.");
        }
    }


    public void receiveMessage() {
        try {
            if (connectedSystem == null) {
                throw new IllegalStateException("Error: Connection not established.");
            }
            connectedSystem.sendRequestToReceive();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }


    public void readOutboxQueue() {
        System.out.println("Outgoing Messages from SystemA:");
        if (outBoxQueue.isEmpty()) {
            System.out.println("Outbox Queue is empty.");
        } else {
            for (String message : outBoxQueue) {
                System.out.println(message);
            }
        }
    }


    public void readInboxQueue() {
        System.out.println("Incoming Messages to System:");
        if (inBoxQueue.isEmpty()) {
            System.out.println("Inbox Queue is empty.");
        } else {
            for (String message : inBoxQueue) {
                System.out.println(message);
            }
        }
    }


    public void processMessages() {
        if (!inBoxQueue.isEmpty()) {
            String message = inBoxQueue.poll();
            processingStack.push(message);
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