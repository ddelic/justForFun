package ba.osd.vikom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileReadAndWrite {

	public static List<String> readAllLines(String pathToFile) {
		Path p = Paths.get(pathToFile);
		try {
			return Files.readAllLines(p);
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja podataka iz konfiguracionog fajla");
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	// ovdje ima ponovaljanja koda, treba staviti u jednu metodu
	public static boolean writeLines(HashMap<Usluga, Integer> map, String path) {
		Path p = Paths.get(path);
		StringBuilder sveAAAAA = new StringBuilder();
		for (Usluga u : map.keySet()) {
			sveAAAAA.append(u.toString());
		}
		try {
			if (!Files.exists(p))
				Files.createFile(p);
			Files.write(Paths.get(path), sveAAAAA.toString().getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Greska prilikom ispisa u fajl ");
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean writeLines(String line, String path) {
		Path p = Paths.get(path);
		try {
			if (Files.exists(p))
				Files.delete(p);
			Files.createFile(p);
			Files.write(Paths.get(path), line.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Greska prilikom ispisa u fajl ");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
