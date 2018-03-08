package pl.sternik.pb.sklep;

import java.io.FileNotFoundException;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.mockito.cglib.core.Local;

import pl.sternik.pb.sklep.zad25.*;

public class Article {

	private static Scanner s = new Scanner(System.in);
	
    private int id;
    private String name;
    private String description;
    private double price;
    private Date dateAdded;

	static int counter;

    private static final Logger log = Logger.getLogger("Article");

    public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        printChange();
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
    }
    
    // Zadanie 30
    public String toStringFormatter() throws FileNotFoundException {	
    	
    	DateFormat dF = DateFormat.getDateInstance(DateFormat.SHORT);
    	
    	return String.format("----------------\nID: %s\nName: %s\nDescription: %s\nPrice: %s\nDate: %s\n--------------", 
    			id, name, description, (new DecimalFormat(".##")).format(price), dF.format(dateAdded));
    }

    public Article(int id, String name, String description, double price, Date dateAdded) {
        try{
        	
        	if(id < 0) throw new BadArticleIDException("ID nie może być poniżej 0", id);
        	if(id <= counter) throw new ArticleIDException("Błędne ID", id);
        	
        	//assert(id % 2 == 0);
        	        	
            counter = id;
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.dateAdded = dateAdded;
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }

    }
    
    public Article(String def, Article[] arts) {
    	
    	try {
        	String[] info = def.split(":");
        	if(info.length != 4) throw new ArticleFormatExcpetion("Zły format danych");
        	
        	int id = Integer.parseInt(info[0]);
        	for (int i = 0; i < arts.length; i++) {
        	
				if(arts[i] != null && id == arts[i].getId()) 
					throw new ArticleIDException("Powtorzone id", id);
			}
        	
			this.id = id;
			this.name = info[1];
			this.description = info[2];
			this.price = Double.parseDouble(info[3]);

    	}catch(ArticleIDException e) {
    		System.out.println(e.getMessage());
    	}
    }

    public Article() {
        counter++;
        this.id = counter;
        this.name = "Brak nazwy";
        this.description = "Brak opisu";
        this.price = 0.0d;
        this.dateAdded = new Date();
    }

    protected void printChange() {
        log.debug("Zmieniono wartość pola");
    }


    public static void main(String[] args)  throws Exception {
    	
    	
        Article[] articles = new Article[2];
        articles[0] = new Article("1:Abc:Opis:5", articles);
        articles[1] = new Article("1:Abc:Opis:5", articles);
    	
    	Article a2 = new Article(1, "Milk", "Opis 02-04-2015", 5.252234d, new Date());
    	System.out.println("Czy w opisie znajduje sie data: " + isDateInDescription(a2));
    	
    	System.out.println(a2.toStringFormatter());
    	
    	Article a3 = getArticle("1 Milk Abc 12,50 16.02.2018");
    	System.out.println("Z dodaną datą: " + a3.toString());
        
        System.out.print("Podaj ID:");
    	int id = s.nextInt();
    	
    	Article a1 = new Article(id, "Milk", "Opis", 5, new Date());
    }
    
    
    // 28 zad
    public static Article getArticle(String str) throws Exception {

    	Scanner s = new Scanner(str);
    	int id = s.nextInt();
    	String name = s.next();
    	String desc = s.next();
    	float val = s.nextFloat();
    	
    	DateFormat dF = DateFormat.getDateInstance(DateFormat.MEDIUM);
    	Date dat = dF.parse(s.next());
    	
    	s.close();

    	return new Article(id, name, desc, val, dat);
    }
    
    static boolean isDateInDescription(Article a) {
    
    	String regex = "\\d{2}-\\d{2}-\\d{4}";
    	Pattern p = Pattern.compile(regex);
    	Matcher m = p.matcher(a.getDescription());
    	
    	return m.find();
    }
}