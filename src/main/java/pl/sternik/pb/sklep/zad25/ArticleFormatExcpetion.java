package pl.sternik.pb.sklep.zad25;

public class ArticleFormatExcpetion extends RuntimeException {
	
	public ArticleFormatExcpetion(String msg) {
		super ("Artucle Format Expection: " + msg);
	}
}
