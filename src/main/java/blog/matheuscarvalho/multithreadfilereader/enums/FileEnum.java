package blog.matheuscarvalho.multithreadfilereader.enums;

public enum FileEnum {

	PLAYER_SPLITTER("\\s{4}"), PLAYER_DIRECTORY("F:\\Development\\Util\\Files\\");

	private String value;

	private FileEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
