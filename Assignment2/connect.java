package Assignment2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class connect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
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


        while (!exit) {
            System.out.println("\n===== Menu =====");

            if (!systemA.isConnected() && !systemB.isConnected()) {
                System.out.println("1. Connect systems");
                System.out.println("2. Connect SystemA to SystemB");
                System.out.println("3. Connect SystemB to SystemA");
            } else {
                if (systemA.isConnected()) {
                    System.out.println("SystemsA");
                    System.out.println("1. CheckConnect");
                    System.out.println("2. Send message from SystemA to SystemB");
                    System.out.println("5. Receive message on SystemA");
                    System.out.println("6. Read outgoing messages from SystemA");
                    System.out.println("7. Read incoming messages from SystemA");
                    // Add other options for SystemA
                }
                if (systemB.isConnected()) {
                    System.out.println("SystemsB");
                    System.out.println("1. CheckConnect");
                    System.out.println("3. Send message from SystemB to SystemA");
                    System.out.println("4. Receive message on SystemB from SystemA");
                    System.out.println("8. Read incoming messages from SystemB");
                    System.out.println("9. Read outgoing messages from SystemA");
                    // Add other options for SystemB
                }
            }

            System.out.println("10. Process messages on both systems");
            System.out.println("11. Disconnect systems");
            System.out.println("12. Switch on systems");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (!systemA.isConnected() && !systemB.isConnected()) {
                        System.out.println("Choose systems to connect:");
                        int connectChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (connectChoice == 2) {
                            systemA.connect(systemB);
                        } else if (connectChoice == 3) {
                            systemB.connect(systemA);
                        } else {
                            System.out.println("Invalid choice for connection");
                        }
                    } else {
                        System.out.println("Systems are already connected.");
                    }
                    break;
                case 2: // Send message from SystemA to SystemB
                    if (systemA.isConnected()) {
                        {
                            System.out.println("Sending a message from SystemA to SystemB");
                            System.out.print("Enter the message: ");
                            String messageAtoB = scanner.nextLine();

                            // Kiểm tra kết nối trước khi gửi tin nhắn
                            if (systemA.isConnected()) {
                                systemA.sendMessage(messageAtoB); // Gửi tin nhắn từ SystemA đến SystemB
                                System.out.println("Message sent from SystemA to SystemB.");
                                systemB.receiveMessageFromSystem(systemA); // Xử lý tin nhắn nhận được ở SystemB
                            } else {
                                System.out.println("Systems are not connected.");
                            }
                        }
                    }
                    break;

                case 3: // Send message from SystemB to SystemA
                    if (systemB.isConnected()) {
                        {
                            System.out.println("Sending a message from SystemB to SystemA");
                            System.out.print("Enter the message: ");
                            String messageBtoA = scanner.nextLine();

                            // Kiểm tra kết nối trước khi gửi tin nhắn
                            if ( systemB.isConnected()) {
                                systemB.sendMessage(messageBtoA); // Gửi tin nhắn từ SystemB đến SystemA
                                System.out.println("Message sent from SystemB to SystemA.");
                                systemA.receiveMessageFromSystem(systemB); // Xử lý tin nhắn nhận được ở SystemA
                            } else {
                                System.out.println("Systems are not connected.");
                            }
                        }
                    } else {
                        System.out.println("SystemB is not connected to SystemA.");
                    }
                    break;

                case 4:
                    if (systemB.isConnected()) {
                        System.out.println("Receiving messages on SystemB from SystemA");
                        systemB.receiveMessageFromSystem(systemA);
                    } else {
                        System.out.println("SystemB is not connected to SystemA.");
                    }
                    break;
                case 5:
                    if (systemA.isConnected()) {
                        System.out.println("Receiving messages on SystemA");
                        systemA.receiveMessageFromSystem(systemB);
                    } else {
                        System.out.println("SystemA is not connected to SystemB.");
                    }
                    break;
                case 6:
                    if (systemA.isConnected()) {
                        System.out.println("Reading outgoing messages from SystemA");
                        systemA.readOutboxQueue();
                    } else {
                        System.out.println("SystemA is not connected to SystemB.");
                    }
                    break;
                case 7:
                    if (systemA.isConnected()) {
                        System.out.println("Reading incoming messages from SystemA");
                        systemA.readInboxQueue();
                    } else {
                        System.out.println("SystemA is not connected to SystemB.");
                    }
                    break;
                case 8:
                    if (systemB.isConnected()) {
                        System.out.println("Reading incoming messages from SystemB");
                        systemB.readInboxQueue();
                    } else {
                        System.out.println("SystemB is not connected to SystemA.");
                    }
                    break;
                case 9:
                    if (systemB.isConnected()) {
                        System.out.println("Reading outgoing messages from SystemB");
                        systemB.readOutboxQueue();
                    } else {
                        System.out.println("SystemB is not connected to SystemA.");
                    }
                    break;
                case 10:


                        if (systemA.isConnected()) {
                            System.out.println("Processing messages on SystemA");
                            systemA.processMessages();
                        } else {
                            System.out.println("SystemA is not connected.");
                        }

                        if (systemB.isConnected()) {
                            System.out.println("Processing messages on SystemB");
                            systemB.processMessages();
                        } else {
                            System.out.println("SystemB is not connected.");
                        }

                    break;
                case 11:
                    if (systemA.isConnected() || systemB.isConnected()) {
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
                    } else {
                        System.out.println("Systems are not connected.");
                    }
                    break;
                case 12:
                    System.out.println("Choose systems to connect:");
                    System.out.println("1. Connect SystemA to SystemB");
                    System.out.println("2. Connect SystemB to SystemA");
                    int connectChoices = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (connectChoices == 1) {

                        systemA.connect(systemB);

                    } else if (connectChoices == 2) {

                        systemB.connect(systemA);

                    }
                    break;
                case 13:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
                    break;
            }

        }
        scanner.close();

    }}
        // Reset các biến hệ thống tại đây (nếu cần)

