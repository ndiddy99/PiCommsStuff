
public class VisionPacketObject {
	String name;
	int value;

	public VisionPacketObject(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String outputPacket() {
		return name + ":" + value + "!";
	}

	@Override
	public String toString() {
		return "Name: " + name + " Value: " + value;
	}
}
