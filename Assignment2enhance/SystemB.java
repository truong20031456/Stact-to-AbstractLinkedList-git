package Assignment2enhance;



import java.util.Queue;
import java.util.Stack;

public class SystemB extends BigSystem {

    private SystemA systemAConnection; // Assuming SystemA is another class in your system

    public SystemB(Queue<String> inBoxQueue, Queue<String> outBoxQueue, Stack<String> processingStack) {
        this.inBoxQueue = inBoxQueue;
        this.outBoxQueue = outBoxQueue;
        this.processingStack = processingStack;
        this.systemAConnection = null; // Initially, there's no connection
    }

    public void establishConnection(SystemA systemA) {
        this.systemAConnection = systemA; // Set the connection object to SystemA
    }

    public void sendRequestToReceive() {
        if (systemAConnection != null) {
            // Perform operations with SystemA connection
            if (getOutBoxQueue().isEmpty()) {
                System.out.println("SystemA's outboxQueue is empty.");
            } else {
                getInBoxQueue().offer(getOutBoxQueue().poll());
                System.out.println("Received messages from SystemA.");
            }
        } else {
            System.out.println("Error: Connection not established with SystemA.");
        }
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
        if (systemAConnection != null) {
            System.out.println("Received message from SystemA: " + message);
            getInBoxQueue().offer(message);
        } else {
            System.out.println("Error: Connection not established with SystemA.");
        }
    }
}
