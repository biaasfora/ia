import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Rodar {
    public static void main(String[] args) throws IOException {
	CSVReader reader = new CSVReader(new FileReader("data.csv"));
	FileWriter writer = new FileWriter("out.csv");

	List<String[]> myEntries = reader.readAll();
	List<Cachorro> cachorros = new ArrayList<Cachorro>();

	for (String[] strings : myEntries) {
		Cachorro c = new Cachorro(strings);
	    cachorros.add(c);
	}

	Kmeans kmeans = new Kmeans();
	for (int k = 1; k <= 5; k++) {
	    Kmeansresultado resultado = kmeans.calcular(cachorros, k);
	    writer.write("------- Con k=" + k + " aux=" + resultado.getAux()
		    + "-------\n");
	    int i = 0;
	    for (Grupo grupo : resultado.getGrupo()) {
		i++;
		writer.write("-- Grupo " + i + " --\n");
		for (Cachorro cachorro : Grupo.getCachorros()) {
		    writer.write(cachorro.toString() + "\n");
		}
		writer.write("\n");
		writer.write(grupo.getCentroide().toString());
		writer.write("\n\n");
	    }
	}
	writer.close();
    }
}