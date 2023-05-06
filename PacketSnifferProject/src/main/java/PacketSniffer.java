import java.util.List;
import java.util.Scanner;
import org.pcap4j.core.BpfProgram;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

public class PacketSniffer {
    public static void main(String[] args) throws Exception {
        // Get a list of all available network interfaces
        List<PcapNetworkInterface> devices = Pcaps.findAllDevs();

        // Print out the available interfaces
        System.out.println("Available interfaces:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getName() + " - " + devices.get(i).getDescription());
        }

        // Prompt the user to select an interface
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an interface (1-" + devices.size() + "): ");
        int choice = scanner.nextInt();

        // Get the selected interface
        PcapNetworkInterface device = devices.get(choice - 1);

        // Print out information about the selected interface
        System.out.println("Listening on interface: " + device.getName() + " - " + device.getDescription());

        // Open the selected interface for capturing
        int snapLen = 64 * 1024; // Capture packets up to 64K in size
        int timeout = 10 * 1000; // Stop capturing after 10 seconds of inactivity
        PromiscuousMode mode = PromiscuousMode.PROMISCUOUS; // Capture all packets
        PcapHandle handle = device.openLive(snapLen, mode, timeout);

        // Compile and apply a filter
        String filter = "ip"; // Capture only IP packets
        handle.setFilter(filter, BpfProgram.BpfCompileMode.OPTIMIZE);

        // Capture packets
        int maxPackets = 10; // Capture a specific number of packets
        for (int i = 0; i < maxPackets; i++) {
            try {
                Packet packet = handle.getNextPacketEx();
                System.out.println(packet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Close the device when you're done capturing
        handle.close();
        scanner.close();
    }
}
