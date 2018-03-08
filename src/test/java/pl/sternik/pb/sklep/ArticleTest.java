package pl.sternik.pb.sklep;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

public class ArticleTest {

	@Test
	public void testMain() throws Exception {
		//Article a = new Article(1, "Milk", "Opis 02s04-2015 aaa", 5); // Fail
		Article a = new Article(1, "Milk", "Opis 02-04-2015 aaa", 5, new Date());
		
		boolean expected = true;
		boolean status = Article.isDateInDescription(a);
		
		assertThat(status).isEqualTo(expected);
	}
	
	@Test
	public void testGetArticle() throws Exception {
		String str = "1 Milk Abc 12,50";
		Article expected = new Article(1, "Milk", "Abc", 12.50, new Date());
		Article status = Article.getArticle(str);
		
		assertThat(status.toString()).isEqualTo(expected.toString());
	}

}
