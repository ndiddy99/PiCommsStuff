//import java.util.Scanner;
//import java.util.logging.Handler;
public class SerialDriver {
	public static void main(String[] args) {
		//Scanner in=new Scanner(System.in);
		System.out.println("Enter string to send");
		try {
			PiRioSerial serial=new PiRioSerial();
			while (true) {
				if (serial.getHandler().interpret() !="")
					System.out.println(serial.getHandler().interpret());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
