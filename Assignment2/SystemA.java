package Assignment2;

import java.util.Queue;
import java.util.Stack;

public class SystemA extends BigSystem {

    public SystemA(Queue<String> inBoxQueue, Queue<String> outBoxQueue, Stack<String> processingStack) {
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
        System.out.println("Outgoing Messages from SystemA:");
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
        System.out.println("Incoming Messages to SystemA:");
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
}
