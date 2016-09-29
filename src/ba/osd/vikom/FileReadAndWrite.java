package ba.osd.vikom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileReadAndWrite {

	public static List<String> readAllLines(String pathToFile) {
			Path p = Paths.get(pathToFile);
			try {
				return Files.readAllLines(p);
			}
			catch (IOException e) {
				System.out.println("Greska prilikom citanja podataka iz konfiguracionog fajla");
				e.printStackTrace();
				return new ArrayList<>();
			}
	}
	
	public static boolean writeLines(List<String> lines) {
		for(String l : lines) {
			try {
				Files.write(Paths.get("./output.txt"), l.getBytes(), StandardOpenOption.APPEND);
			}
			catch (IOException e) {
				System.out.println("Greska prilikom ispisa u fajl ");
				e.printStackTrace();
				return false;
			}
		}		return true;
	}

}
