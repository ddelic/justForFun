package ba.osd.vikom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		List<Usluga> listaUsluga = new ArrayList();
		StringBuilder toFile = new StringBuilder();
		toFile.append(HEADER);
		toFile.append(DATUM);
		String path = "./config.ini";
		for (String l : FileReadAndWrite.readAllLines(path)) {
			Scanner scan = new Scanner(l);
			String[] split = l.split("#");
			listaUsluga.add(new Usluga(split[0], Double.valueOf(split[1])));
		}

		HashMap<Usluga, Integer> zaFakturu = Akcija.kreirajRacun(listaUsluga);
		Double ukupnoKM = 0.0;
		for (Usluga u : zaFakturu.keySet()) {
			System.out.print(u);
			System.out.println(
					"\tKolicina: " + zaFakturu.get(u) + "\tUkupuna cijena usluge: " + zaFakturu.get(u) * u.getCijena());
			ukupnoKM += zaFakturu.get(u) * u.getCijena();
			toFile.append(u.toString() + "\tKolicina: " + zaFakturu.get(u) + "\tUkupuna cijena usluge: "
					+ zaFakturu.get(u) * u.getCijena() + "\n");
		}
		System.out.println("\nUkupno KM: " + ukupnoKM);
		toFile.append("\nUkupno KM: " + ukupnoKM + "\n");
		toFile.append(HEADER);

		// ispis u fajl
		// FileReadAndWrite.writeLines(zaFakturu, "./izlaz.txt");
		FileReadAndWrite.writeLines(toFile.toString(), "./izlaz.txt");
		// FileReadAndWrite.writeLines("\nUkupno KM: "+ukupnoKM, "./izlaz.txt");
	}

	public static String HEADER = "============================================================================================================================\n";

	public static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static Date date = new Date();
	public static String DATUM = "\n*************************************************Datum :" + dateFormat.format(date)
			+ "*************************************************\n\n";

}
