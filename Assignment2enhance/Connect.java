package Assignment2enhance;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Connect {
    public static void main(String[] args) {
        Queue<String> inBoxQueueA = new LinkedList<>();
        Queue<String> outBoxQueueA = new LinkedList<>();
        Stack<String> processingStackA = new Stack<>();

        Queue<String> inBoxQueueB = new LinkedList<>();
        Queue<String> outBoxQueueB = new LinkedList<>();
        Stack<String> processingStackB = new Stack<>();

        SystemA systemA = new SystemA(inBoxQueueA, outBoxQueueA, processingStackA);
        SystemB systemB = new SystemB(inBoxQueueB, outBoxQueueB, processingStackB);

        // Handshaking
        systemA.connect(systemB);
        systemB.connect(systemA);

        // Sending a message from SystemA to SystemB
        systemA.sendMessageToSystemB(systemB, "Truong from SystemA to SystemB");

        // Receiving messages on SystemA
        systemA.receiveMessage();

        // Reading outgoing messages from SystemA and incoming messages from SystemB
        systemA.readOutboxQueue();
        systemA.readInboxQueue();

        // Processing messages on both systems
        systemA.processMessages();
        systemB.processMessages();

        // Disconnecting
        systemA.disconnect();
        systemB.disconnect();
    }
}
