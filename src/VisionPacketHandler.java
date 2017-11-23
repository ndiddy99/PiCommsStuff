
import java.util.ArrayList;

public class VisionPacketHandler {
	VisionPacketObject[] visionPackets;
	public VisionPacketHandler(VisionPacketObject[] visionPackets) {
		this.visionPackets=visionPackets;
	}
	public String outputVisionPacket() {
		String stringToOutput="<";
		for (int i=0; i < visionPackets.length; i++) {
			stringToOutput+=visionPackets[i].outputPacket();
		}
		stringToOutput+=">";
		return stringToOutput;
	}
	public VisionPacketObject[] decodeVisionPacket(String packetToDecode) {
		ArrayList<VisionPacketObject>visionPackets = new ArrayList<>();
		
		while(packetToDecode.contains("!")) {
			String name = packetToDecode.substring(0, packetToDecode.indexOf(":"));
			String stringValue = packetToDecode.substring(packetToDecode.indexOf(":") + 1, packetToDecode.indexOf("!"));
			int value = Integer.valueOf(stringValue);
			VisionPacketObject visionPacketObject = new VisionPacketObject(name, value);
			visionPackets.add(visionPacketObject);
			packetToDecode=packetToDecode.substring(packetToDecode.indexOf("!")+1, packetToDecode.length());
			
		}
		return visionPackets.toArray(new VisionPacketObject[visionPackets.size()]);
	}
}