package Assignment2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Connect {
    public static void main(String[] args) {
        Queue<String> OutBoxQueueA = new LinkedList<>();
        Queue<String> InBoxQueueA = new LinkedList<>();
        Stack<String> processingStackA = new Stack<>();
        Queue<String> OutBoxQueueB = new LinkedList<>();
        Queue<String> InBoxQueueB = new LinkedList<>();
        Stack<String> processingStackB = new Stack<>();

        BigSystem systemA = new BigSystem(OutBoxQueueA, InBoxQueueA, processingStackA);
        systemA.setName("systemA");
        BigSystem systemB = new BigSystem(OutBoxQueueB, InBoxQueueB, processingStackB);
        systemB.setName("systemB");

    // Handshaking

        // Sending a message from SystemA to SystemB

          //*  System.out.println("Handshaking...");
        systemA.connect(systemB);


            // Gọi các hàm và in ra thông điệp kiểm tra
            // Ví dụ:
           System.out.println("Sending a message from SystemA to SystemB");
            systemA.sendMessage("Tôi là Howl và tôi muốn gữi tin nhắn này từ system A đến B một cách nhanh nhất nhưng maf hầu heet bi ");

            System.out.println("Receiving messages on SystemB from SystemA");
            systemB.receiveMessageFromSystem(systemA);
//*
            System.out.println("Receiving messages on SystemA");
            systemA.receiveMessage();

          System.out.println("Reading outgoing messages from SystemA");
            systemA.readOutboxQueue();

           System.out.println("Reading incoming messages from SystemB");
            systemB.readInboxQueue();

    System.out.println("Processing messages on both systems");
            systemA.processMessages();
            systemB.processMessages();
       System.out.println("Disconnecting...");
        systemA.disconnect();
        systemB.disconnect();
      /* long startTimeSystemA = System.currentTimeMillis();
        systemA.processMessages();
        long endTimeSystemA = System.currentTimeMillis();
        long executionTimeSystemA = endTimeSystemA - startTimeSystemA;
        System.out.println("SystemA processMessages() execution time: " + executionTimeSystemA + " milliseconds");

// Measure execution time for processMessages() in SystemB
        long startTimeSystemB = System.currentTimeMillis();
        systemB.processMessages();
        long endTimeSystemB = System.currentTimeMillis();
        long executionTimeSystemB = endTimeSystemB - startTimeSystemB;
        System.out.println("SystemB processMessages() execution time: " + executionTimeSystemB + " milliseconds");
        // Measure execution time for sendMessage() in SystemA
        long startTimeSendMessage = System.currentTimeMillis();
        systemA.sendMessage("Test message");
        long endTimeSendMessage = System.currentTimeMillis();
        long executionTimeSendMessage = endTimeSendMessage - startTimeSendMessage;
        System.out.println("SystemA sendMessage() execution time: " + executionTimeSendMessage + " milliseconds");

// Measure execution time for receiveMessage() in SystemA
        long startTimeReceiveMessage = System.currentTimeMillis();
        systemA.receiveMessage();
        long endTimeReceiveMessage = System.currentTimeMillis();
        long executionTimeReceiveMessage = endTimeReceiveMessage - startTimeReceiveMessage;
        System.out.println("SystemA receiveMessage() execution time: " + executionTimeReceiveMessage + " milliseconds");*/

// Similarly, measure execution time for other methods in SystemA or SystemB

    }

    }


