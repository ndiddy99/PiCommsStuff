import java.util.Scanner;
public class SerialDriver {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter string to send");
		try {
			PiRioSerial serial=new PiRioSerial();
			serial.writeString(in.nextLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
