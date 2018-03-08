package pl.sternik.pb.sklep.zamowienia;

public class Order {

	private double kwota;
	private Platnosc platnosc;
	
	public Order(Platnosc platnosc, double kwota) {
		this.platnosc = platnosc;
		this.kwota = kwota;
	}
	
	public boolean oplacZamowienie() {	
		return platnosc.zaplac(kwota);
	}
	
	public boolean oplacZamowienie(Platnosc platnosc) {	
		return platnosc.zaplac(kwota);
	}
	
	public static void main(String[] args) {
		Order o = new Order(new Karta(), 2);
		o.oplacZamowienie();
		
		o = new Order(new Gotowka(), 12);
		o.oplacZamowienie();
	}
}
