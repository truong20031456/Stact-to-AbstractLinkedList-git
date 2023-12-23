package Assignment2;

import java.util.Queue;
import java.util.Stack;

public class SystemB extends BigSystem {

    public SystemB(Queue<String> inBoxQueue, Queue<String> outBoxQueue, Stack<String> processingStack) {
        this.inBoxQueue = inBoxQueue;
        this.outBoxQueue = outBoxQueue;
        this.processingStack = processingStack;
    }
    public void sendRequestToReceive() {
        if (isConnected()) {
            // Check if SystemA has messages
            if (getOutBoxQueue().isEmpty()) {
                // If SystemA's outboxQueue is empty
                System.out.println("SystemA's outboxQueue is empty.");
            } else {
                // Otherwise, send messages to SystemA's inboxQueue
                getInBoxQueue().offer(getOutBoxQueue().poll());
                System.out.println("Received messages from SystemA.");
            }
        } else {
            // If the connection is not established
            System.out.println("Error: Connection not established with SystemA.");
        }
    }

    private boolean isConnected() {
        return false;
    }

    @Override
    public void sendMessage(String message) {
        if (message.isEmpty()) {
            System.out.println("Error: Message is empty.");
            return;
        }
        if (message.length() > 250) {
            System.out.println("Error: Message is too long. Truncating message.");
            // Logic to truncate the message into smaller messages
        }
        outBoxQueue.offer(message);
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
        System.out.println("Outgoing Messages from SystemB:");
        if (outBoxQueue.isEmpty()) {
            System.out.println("Outbox Queue is empty.");
        } else {
            int messageCount = outBoxQueue.size();
            System.out.println("Number of messages in Outbox Queue: " + messageCount);
            System.out.println("Messages:");
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
            int messageCount = inBoxQueue.size();
            System.out.println("Number of messages in Inbox Queue: " + messageCount);
            System.out.println("Messages:");
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
        if (isConnected()) {
            // Xử lý tin nhắn từ SystemA
            System.out.println("Received message from SystemA: " + message);
            getInBoxQueue().offer(message); // Lưu tin nhắn vào inboxQueue của SystemB
        } else {
            System.out.println("Error: Connection not established with SystemA.");
        }
    }


}
