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
        System.out.println("Outgoing Messages in SystemA:");
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
        System.out.println("Incoming Messages in SystemA:");
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

    public void sendRequestToReceive() {
        if (connectedSystem != null) {
            connectedSystem.receiveMessage(); // Assuming receiveMessage() triggers receiving in SystemA
        } else {
            System.out.println("Error: Connection to SystemA not established.");
        }
    }
    public void sendMessageToSystemB(SystemB systemB, String message) {
        // Gửi tin nhắn từ SystemA sang SystemB
        systemB.receiveMessageFromSystemA(message);
        System.out.println("Message sent from SystemA to SystemB: " + message);
    }

}
