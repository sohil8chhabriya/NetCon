
public enum ProgramsEnum {
	A(1,"A"),
	B(2,"B"),
	C(3,"C"),
	D(4,"D"),
	E(5,"E"),
	F(6,"F"),
	G(7,"G");
	
	private int key;
	private String value;
	ProgramsEnum (int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public int getKey() {
		return this.key;
	}

	public String getValue() {
		return this.value;
	}
	
}
