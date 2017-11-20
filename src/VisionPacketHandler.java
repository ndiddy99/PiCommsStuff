
public class VisionPacketHandler {
	VisionPacketObject[] visionPackets;
	public VisionPacketHandler(VisionPacketObject[] visionPackets) {
		this.visionPackets=visionPackets;
	}
	public String outputVisionPacket() {
		String stringToOutput="<";
		for (int i=0; i < visionPackets.length; i++) {
			stringToOutput+=visionPackets[i].outputPacket()+"!";
		}
		stringToOutput+=">";
		return stringToOutput;
	}
}
