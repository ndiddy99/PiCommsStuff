
public class ProtocolHandler {
	String buffer;
	boolean isStringReady;
	public ProtocolHandler() {
		buffer="";
		isStringReady=false;
	}
	/*
	 * Example packet of the protocol we're using:
	 *  <Sensor1:1!Sensor2:2!Sensor3:3>
	 *  pretty much, the greater than/less than symbols frame the packets
	 *  the "Sensorx" text is the sensor that you're using (can be any string)
	 *  the numbers are the values that that sensor is returning
	 *  the exclamation points separate sensor values
	 */
	public void append(String stringToAppend) {
		for (int i=0; i < stringToAppend.length();i++) {
			char charToAppend=stringToAppend.charAt(i);
			if (charToAppend=='<') {  //is current character opening character?
				buffer="<";			//if yes, reset the buffer
				isStringReady=false;
			}
			else if (charToAppend=='>') { //is current char closing character?
				buffer+='>';		//if yes, buffer is ready for program to read
				isStringReady=true;
				System.out.println(buffer);
			}
			else 				//otherwise, add current char to the buffer
				buffer+=charToAppend;
		}
	}
}
