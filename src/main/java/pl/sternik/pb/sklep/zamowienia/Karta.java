package pl.sternik.pb.sklep.zamowienia;

public class Karta implements Platnosc {

	@Override
	public boolean zaplac(double kwota) {
		System.out.println("Platnosc karta! za: " + kwota);
		return true;
	}

}
