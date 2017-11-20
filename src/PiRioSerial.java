import java.io.IOException;

import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.SerialPort;

public class PiRioSerial {
	int baudrate;
	final Serial serial;
	ProtocolHandler handler;
	public PiRioSerial() throws Exception {
		handler=new ProtocolHandler();
		this.baudrate=38400; 
		serial = SerialFactory.createInstance();
		serial.open(SerialPort.getDefaultPort(), baudrate);
        serial.addListener(new SerialDataEventListener() {
            public void dataReceived(SerialDataEvent event) {
                    try {
						handler.append(event.getAsciiString());
					} catch (IOException e) {
						e.printStackTrace();
					}
            }
        });
	}
	public void writeString(String stringToWrite) throws Exception {
		serial.write(stringToWrite);
	}
	public ProtocolHandler getHandler() {
		return handler;
	}
	
}
