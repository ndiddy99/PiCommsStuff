
public class ProtocolHandler {
	String buffer;
	String lastCompletedString;
	public ProtocolHandler() {
		buffer="";
		lastCompletedString="";
	}
	/*
	 * Example packet of the protocol we're using:
	 *  <Name1:1.2!Name2:2.3!Name3:3.4!>
	 *  pretty much, the greater than/less than symbols frame the packets
	 *  the "Namex" text is the variable name(can be any string)
	 *  the numbers are the values stored by the values
	 *  the exclamation points separate values
	 */
	public void append(String stringToAppend) {
		for (int i=0; i < stringToAppend.length();i++) {
			char charToAppend=stringToAppend.charAt(i);
			if (charToAppend=='<') {  //is current character opening character?
				buffer="<";			//if yes, reset the buffer
			}
			else if (charToAppend=='>') { //is current char closing character?
				buffer+='>';		//if yes, buffer is ready for program to read
				lastCompletedString=buffer;
			}
			else 				//otherwise, add current char to the buffer
				buffer+=charToAppend;
		}
	}
	public String interpret() {
		String interpretedString="";
		for (int i=0; i < lastCompletedString.length();i++) {
			char charToAppend=lastCompletedString.charAt(i);
			if (charToAppend=='<' || charToAppend=='>') {
				interpretedString+="";
			}
			else if (charToAppend=='!') {
				interpretedString+="\n";
			}
			else {
				interpretedString+=charToAppend;
			}
		}
		return interpretedString;
	}
}
