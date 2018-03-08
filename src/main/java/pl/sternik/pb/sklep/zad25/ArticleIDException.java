package pl.sternik.pb.sklep.zad25;

public class ArticleIDException extends BadArticleIDException {
	
	public ArticleIDException(String msg, int id) {
		super("Article ID Exception: " + msg, id);
	}
}
