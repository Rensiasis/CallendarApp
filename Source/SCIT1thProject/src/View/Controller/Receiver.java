package View.Controller;

public class Receiver {
	private static Object message;

	public Receiver(Object message) {
		super();
		this.message = message;
	}

	public Receiver() {
		super();
	}

	public static Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

}
