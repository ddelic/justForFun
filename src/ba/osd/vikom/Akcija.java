package ba.osd.vikom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Akcija {
	
	public static HashMap<Usluga, Integer> kreirajRacun(List<Usluga> usluge) {
		HashMap<Usluga, Integer> mapa = new HashMap<Usluga, Integer>();
		ArrayList<Usluga> odabraneUsluge = new ArrayList<>();
		Random rand = new Random();
		
		int koraci = 0;
		double total = 0.0;
		int j;
		int[] flags = new int[usluge.size()];
		
		int random = rand.nextInt(usluge.size()/3) + 5;
		for (int i = 0; i < random; i++) {
			do {
				j = rand.nextInt(16);
			}
			while (flags[j] == 1);
			flags[j] = 1;
			odabraneUsluge.add(usluge.get(j));
		}

		for (int i = 0; i < random; i++) {
			odabraneUsluge.get(i).setMin((int) ((ukupanIznos / ((double) random)) / (2.0 * odabraneUsluge.get(i).getCijena())));
			odabraneUsluge.get(i).setMax((int) ((ukupanIznos / ((double) random)) / (0.66 * odabraneUsluge.get(i).getCijena())));
		}
		
		
		while (total != ukupanIznos) {
			// svaki put isprazni mapu
			if(!clearMap(mapa)) {
				System.out.println("Greska prilikom brisanja usluga!");
				break;
			}
			total = 0;
			for (int i = 0; i < random; i++) {
				int kol = rand.nextInt(odabraneUsluge.get(i).getMax() + 1 - odabraneUsluge.get(i).getMin()) + odabraneUsluge.get(i).getMin() + 1;
				total += kol * odabraneUsluge.get(i).getCijena();
				mapa.put(odabraneUsluge.get(i),kol);
			}
			System.out.println(total);
			System.out.println();
			koraci++;
		}
		//System.out.println("Broj koraka: " + koraci);
		//System.out.println("Broj stavki: " + random);
		
		return mapa;
	}
	
	private static boolean clearMap(HashMap<Usluga, Integer> mapa) {
		mapa.clear();
		return mapa.size() == 0;
	}
	
	private static double ukupanIznos = 2075;
}
