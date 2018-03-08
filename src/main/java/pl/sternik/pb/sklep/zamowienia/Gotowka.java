package pl.sternik.pb.sklep.zamowienia;

public class Gotowka implements Platnosc {

	@Override
	public boolean zaplac(double kwota) {
		System.out.println("Platnosc gotowka! za: " + kwota);
		return true;
	}

}
