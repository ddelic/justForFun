package ba.osd.vikom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		
		List<Usluga> listaUsluga = new ArrayList();
		String path = "./config.ini";
		for(String l : FileReadAndWrite.readAllLines(path)) {
			Scanner scan = new Scanner(l);
			String[] split = l.split("#");
			listaUsluga.add(new Usluga(split[0], Double.valueOf(split[1])));
		}
		
		HashMap<Usluga, Integer> zaFakturu = Akcija.kreirajRacun(listaUsluga);
		Double ukupnoKM = 0.0;
		for(Usluga u : zaFakturu.keySet()) {
			System.out.print(u);
			System.out.println("\tKolicina: "+zaFakturu.get(u) + "\tUkupuna cijena usluge: "+zaFakturu.get(u)*u.getCijena());
			ukupnoKM += zaFakturu.get(u)*u.getCijena();
		}
		System.out.println("\nUkupno KM: "+ukupnoKM);
	}

}
