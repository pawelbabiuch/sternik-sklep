package pl.sternik.pb.sklep.zad25;

public class BadArticleIDException extends Exception{

	public BadArticleIDException(String msg, int id) {
		super("Bad article ID exception: " + msg + " ID: " + id);
	}
}
