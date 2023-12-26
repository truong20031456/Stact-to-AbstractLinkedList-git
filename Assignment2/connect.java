package Assignment2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class connect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Connect systems");
            System.out.println("2. Send message from SystemA to SystemB");
            System.out.println("3. Receive message on SystemB from SystemA");
            System.out.println("4. Receive message on SystemA");
            System.out.println("5. Read outgoing messages from SystemA");
            System.out.println("6. Read incoming messages from SystemB");
            System.out.println("7. Process messages on both systems");
            System.out.println("8. Disconnect systems");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Choose systems to connect:");
                    System.out.println("1. Connect SystemA to SystemB");
                    System.out.println("2. Connect SystemB to SystemA");
                    int connectChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (connectChoice == 1) {
                        systemA.connect(systemB);
                    } else if (connectChoice == 2) {
                        systemB.connect(systemA);
                    } else {
                        System.out.println("Invalid choice for connection");
                    }
                    break;
                case 2:
                    System.out.println("Sending a message from SystemA to SystemB");
                    System.out.print("Enter the message: ");
                    String messageAtoB = scanner.nextLine();
                    systemA.sendMessage(messageAtoB);
                    break;
                case 3:
                    System.out.println("Receiving messages on SystemB from SystemA");
                    systemB.receiveMessageFromSystem(systemA);
                    break;
                case 4:
                    System.out.println("Receiving messages on SystemA");
                    systemA.receiveMessage();
                    break;
                case 5:
                    System.out.println("Reading outgoing messages from SystemA");
                    systemA.readOutboxQueue();
                    break;
                case 6:
                    System.out.println("Reading incoming messages from SystemB");
                    systemB.readInboxQueue();
                    break;
                case 7:
                    System.out.println("Processing messages on both systems");
                    systemA.processMessages();
                    systemB.processMessages();
                    break;
                case 8:
                    System.out.println("Choose systems to disconnect:");
                    System.out.println("1. Disconnect SystemA from SystemB");
                    System.out.println("2. Disconnect SystemB from SystemA");
                    int disconnectChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (disconnectChoice == 1) {
                        systemA.disconnect(systemB);
                    } else if (disconnectChoice == 2) {
                        systemB.disconnect(systemA);
                    } else {
                        System.out.println("Invalid choice for disconnection");
                    }
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
                    break;
            }
        }

        scanner.close();
    }
}

// Placeholder class, replace it with your actual BigSystem class implementation


