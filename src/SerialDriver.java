import java.util.Arrays;

//import java.util.Scanner;
//import java.util.logging.Handler;
public class SerialDriver {
	public static void main(String[] args) {
		//Scanner in=new Scanner(System.in);
		System.out.println("Enter string to send");
		try {
			PiRioSerial serial=new PiRioSerial();
			VisionPacketHandler visionPacketHandler=new VisionPacketHandler(null);
			while (true) {
				if (serial.getHandler().getLastString() !="")
					System.out.println(Arrays.toString(visionPacketHandler.decodeVisionPacket(serial.getHandler().getLastString())));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
