
public class VisionPacketObject {
	String name;
	double value;
	public VisionPacketObject(String name, double value) {
		this.name=name;
		this.value=value;
	}
	public String outputPacket() {
		return name+":"+value;
	}
}
