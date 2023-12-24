package Assignment2;

import java.util.Queue;
import java.util.Stack;

public class SystemB extends BigSystem {
    private  boolean connected= false;

    public SystemB(Queue<String> inBoxQueue, Queue<String> outBoxQueue, Stack<String> processingStack) {
        this.inBoxQueue = inBoxQueue;
        this.outBoxQueue = outBoxQueue;
        this.processingStack = processingStack;
    }

    @Override
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

    @Override
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

    @Override
    public void readOutboxQueue() {
        System.out.println("Outgoing Messages from SystemB:");
        if (outBoxQueue.isEmpty()) {
            System.out.println("Outbox Queue is empty.");
        } else {
            for (String message : outBoxQueue) {
                System.out.println(message);
            }
        }
    }

    @Override
    public void readInboxQueue() {
        System.out.println("Incoming Messages to SystemB:");
        if (inBoxQueue.isEmpty()) {
            System.out.println("Inbox Queue is empty.");
        } else {
            for (String message : inBoxQueue) {
                System.out.println(message);
            }
        }
    }

    @Override
    public void processMessages() {
        if (!inBoxQueue.isEmpty()) {
            processingStack.push(inBoxQueue.poll());
        }
    }

    public void receiveMessageFromSystemA(String message) {
        try {
            if (connectedSystem == null) {
                throw new IllegalStateException("Error: Connection not established.");
            }
            connectedSystem.sendRequestToReceive();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendRequestToReceive() {
        if (isConnected()) {
            if (connectedSystem.getOutBoxQueue().isEmpty()) {
                System.out.println("SystemA's outboxQueue is empty.");
            } else {
                inBoxQueue.offer(connectedSystem.getOutBoxQueue().poll());
                System.out.println("Received messages from SystemA.");
            }
        } else {
            System.out.println("Error: Connection not established with SystemA.");
        }
    }
    @Override
    public void connect(BigSystem system) {
        this.connectedSystem = system;
        system.connectedSystem = this;
        System.out.println(this.getClass().getSimpleName() + " is connecting to " + system.getClass().getSimpleName());
        System.out.println(system.getClass().getSimpleName() + " is connecting to " + this.getClass().getSimpleName());
        this.connected = true;
    }

    @Override
    public void disconnect() {
        this.connectedSystem = null;
        this.connected = false;
    }


    public boolean isConnected() {
        return connected;
    }
}
