package Assignment2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BigSystem {

    protected Queue<String> inBoxQueue;
    protected Queue<String> outBoxQueue;
    protected Stack<String> processingStack;
    protected BigSystem connectedSystem;



    public Queue<String> getOutBoxQueue() {
        return outBoxQueue;
    }
    public Queue<String> getInBoxQueue() {
        return inBoxQueue;
    }
    public Stack<String> getProcessingStack() {
        return processingStack;
    }


    private  boolean connected= false;
    public BigSystem() {
        inBoxQueue = new LinkedList<>();
        outBoxQueue=new LinkedList<>();
         processingStack = new Stack<>();

    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void connect(BigSystem system) {
        if (this.getName().equals("systemA") && system.getName().equals("systemB")) {
            this.connectedSystem = system;
            system.connectedSystem = this;

            // Printing connection information only for systemA connecting to systemB
            System.out.println(this.getClass().getSimpleName() + " '" + this.getName() + "' is connecting to " +
                    system.getClass().getSimpleName() + " '" + system.getName() + "'");
            connected= true;
        } else if (this.getName().equals("systemB") && system.getName().equals("systemA")) {
            this.connectedSystem = system;
            system.connectedSystem = this;
            // Do nothing or handle the connection differently if systemB connects to systemA
            // Optionally print a message indicating that the connection is not supported
            System.out.println(this.getClass().getSimpleName() + " '" + this.getName() + "' is connecting to " +
                    system.getClass().getSimpleName() + " '" + system.getName() + "'");
            connected= true;
        }
    }public static class connect {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;



            BigSystem systemA = new BigSystem();
            systemA.setName("systemA");

            BigSystem systemB = new BigSystem();
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



    // Existing code...







    public void sendMessage(String message) {
        try {
            if (connectedSystem == null) {
                throw new IllegalStateException("Error: Not connected to any system.");
            }

            if (connected) {
                if (message.isEmpty()) {
                    throw new IllegalArgumentException("Error: Message is empty.");
                }
                // Xử lý tin nhắn từ SystemB đến SystemA
                if (message.length() > 250) {
                    System.out.println("Error: Message is too long. Truncating message.");
                    int chunkSize = 250;
                    for (int i = 0; i < message.length(); i += chunkSize) {
                        int end = Math.min(message.length(), i + chunkSize);
                        String chunk = message.substring(i, end);
                        getOutBoxQueue() .offer(chunk);
                    }
                } else {
                    getOutBoxQueue() .offer(message);
                }
                System.out.println("Message sent from " + this.getClass().getSimpleName() + " '" + this.getName() + "' to " +
                        connectedSystem.getClass().getSimpleName() + " '" + connectedSystem.getName() + "'");
            } else {
                System.out.println("Error: Not connected to the intended system.");
            }
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }



    public void receiveMessageFromSystem(BigSystem connectedSystem) {
        Queue<String> connectedOutBoxQueue = connectedSystem.getOutBoxQueue();

        // Kiểm tra xem hàng đợi của hệ thống kết nối có tin nhắn hay không
        if (!connectedOutBoxQueue.isEmpty()) {
            // Nếu có tin nhắn, sao chép từ hàng đợi của hệ thống kết nối sang hàng đợi của hệ thống hiện tại
            while (!connectedOutBoxQueue.isEmpty()) {
                String message = connectedOutBoxQueue.poll();
                this.getInBoxQueue().offer(message);
            }
            System.out.println("Received messages from " + connectedOutBoxQueue.getClass().getSimpleName());
        } else {
            // Nếu hàng đợi của hệ thống kết nối rỗng, thông báo rằng không có tin nhắn
            System.out.println(connectedSystem.getClass().getSimpleName() + "'s Outbox Queue is empty.");
        }
    }


    public void sendRequestToReceive() {
        if (isConnected()) {
            if (connectedSystem.getOutBoxQueue().isEmpty()) {
                System.out.println("System's outboxQueue is empty.");
            } else {
                getInBoxQueue().offer(connectedSystem.getOutBoxQueue().poll());
                System.out.println("Received messages from System.");
            }
        } else {
            System.out.println("Error: Connection not established with SystemA.");
        }
    }


/*    public void receiveMessage() {
        try {
            if (connectedSystem == null) {
                throw new IllegalStateException("Error: Connection not established.");
            }
            connectedSystem.sendRequestToReceive();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }*/


    public void readOutboxQueue() {
        System.out.println("Outgoing Messages from " + this.getClass().getSimpleName() + " '" + this.getName() + "':");
        if (getOutBoxQueue().isEmpty()) {
            System.out.println("Outbox Queue is empty.");
        } else {
            for (String message : getOutBoxQueue()) {
                System.out.println(message);
            }
        }
    }

    public void readInboxQueue() {
        System.out.println("Incoming Messages to " + this.getClass().getSimpleName() + " '" + this.getName() + "':");
        if ( getInBoxQueue().isEmpty()) {
            System.out.println("Inbox Queue is empty.");
        } else {
            for (String message :  getInBoxQueue()) {
                System.out.println(message);
            }
        }
    }


    public void processMessages() {
        try {
            if (connectedSystem == null) {
                throw new IllegalStateException("Error: Connection not established.");
            }

            while (!getInBoxQueue().isEmpty()) {
                String message = getInBoxQueue().poll();
                getProcessingStack().push(message);
                System.out.println("Message processed: " + message);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }



    public void disconnect(BigSystem systemToDisconnect) {
        if (this.connectedSystem == null || systemToDisconnect.connectedSystem == null) {
            System.out.println("Both systems are already disconnected.");
        } else if (this.connectedSystem == systemToDisconnect && systemToDisconnect.connectedSystem == this) {
            this.connectedSystem = null;
            systemToDisconnect.connectedSystem = null;

            System.out.println("Disconnected " + systemToDisconnect.getClass().getSimpleName() + " '" + systemToDisconnect.getName() +
                    "' from " + this.getClass().getSimpleName() + " '" + this.getName() + "'");
        } else {
            System.out.println("Invalid disconnection. Please choose the correct systems to disconnect.");
        }
    }




    public boolean isConnected() {
        return connected;
    }

}