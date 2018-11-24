public enum ChannelsEnum {
	HotStar(1,"HotStar"),
	AmazonPrime(2,"AmazonPrime"),
	Netflix(3,"Netflix");
	
	private int key;
	private String value;
	ChannelsEnum (int key, String value) {
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