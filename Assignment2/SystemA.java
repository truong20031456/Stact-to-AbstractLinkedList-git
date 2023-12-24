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
                throw new IllegalArgumentException("Error: Message is too long. Truncating message.");
                // Logic to truncate the message into smaller messages
            }
            outBoxQueue.offer(message);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        if (message.length() > 250) {
            System.out.println("Error: Message is too long. Truncating message.");
            // Logic to truncate the message into smaller messages
            // For example:
            while (message.length() > 250) {
                String substring = message.substring(0, 250);
                outBoxQueue.offer(substring);
                message = message.substring(250);
            }
            outBoxQueue.offer(message);
        } else {
            outBoxQueue.offer(message);
        }
    }

    @Override
    public void receiveMessage() {
        if (connectedSystem == null) {
            System.out.println("Error: Connection not established.");
            return;
        }

        connectedSystem.sendRequestToReceive();
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
