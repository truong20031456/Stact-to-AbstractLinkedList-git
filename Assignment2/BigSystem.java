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
            this.connectedSystem = system;
            system.connectedSystem = this;

            // Assuming `name` is an attribute of BigSystem
            String thisSystemName = this.name != null ? "'" + this.name + "'" : "";
            String connectedSystemName = system.getName() != null ? "'" + system.getName() + "'" : "";

            System.out.println(this.getClass().getSimpleName() + " " + thisSystemName + " is connecting to " + system.getClass().getSimpleName() + " " + connectedSystemName);
            System.out.println(system.getClass().getSimpleName() + " " + connectedSystemName + " is connecting to " + this.getClass().getSimpleName() + " " + thisSystemName);
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
            if (message.isEmpty()) {
                throw new IllegalArgumentException("Error: Message is empty.");
            }
            if (message.length() > 250) {
                System.out.println("Error: Message is too long. Truncating message.");

                // Split the long message into smaller chunks of maximum length 250
                int chunkSize = 250;
                for (int i = 0; i < message.length(); i += chunkSize) {
                    int end = Math.min(message.length(), i + chunkSize);
                    String chunk = message.substring(i, end);
                    outBoxQueue.offer(chunk);
                }
            } else {
                outBoxQueue.offer(message);
            }
        } catch (IllegalArgumentException e) {
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


    public void disconnect() {
        this.connectedSystem = null;
        this.connected = false;
    }


    public boolean isConnected() {
        return connected;
    }




}