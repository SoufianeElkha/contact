package Troisieme_etape;

public class MenuOption {
	private final int option;
	private final String text;

	public MenuOption(int option, String text) {
		this.option = option;
		this.text = text;
	}

	public int getOption() {
		return option;
	}

	public String getText() {
		return text;
	}

}
