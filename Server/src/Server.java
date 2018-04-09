import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

class Server {
	Server(int port) {
	
	}
	
	void run() {
			DatagramSocket socket;
			byte[] buf = new byte[256];
			
			String action;
			int chunkSize;
			String param;
			
			try {
				socket = new DatagramSocket(8999);
				
				while (true) {
					DatagramPacket packet = new DatagramPacket(buf, buf.length);
					try {
						socket.receive(packet);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//InetAddress address = packet.getAddress();
					//int port = packet.getPort();
					//packet = new DatagramPacket(buf, buf.length, address, port);
					String received = new String(packet.getData());
					
					Scanner scanner = new Scanner(received);
					Scanner dayScanner = new Scanner(scanner.next());
					
					dayScanner.useDelimiter(";");
					action = dayScanner.next();
					chunkSize = dayScanner.nextInt();
					param = dayScanner.next();
					
					if(action.equals("HSOSSTP_INITX")){
						System.out.println("Drinne");
					}
				
				/*if (received.equals("end")) {
					running = false;
					continue;
				}
				try {
					socket.send(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}*/
				}
				
			} catch (SocketException e) {
				e.printStackTrace();
			}
		}
}
