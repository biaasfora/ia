import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Random;

/*import au.com.bytecode.opencsv.CSVReader;

public class Rodar {
	/*public static void main(String[] args) throws IOException {
	CSVReader reader = new CSVReader(new FileReader("data.csv"));
	FileWriter writer = new FileWriter("out.csv");

	List<String[]> myEntries = reader.readAll();
	List<Cachorro> cachorros = new ArrayList<Cachorro>();

	for (String[] strings : myEntries) {
		Cachorro c = new Cachorro(strings);
	    cachorros.add(c);
	}
*//* public static void main(String[]args) throws IOException{
	FileReader reader = new FileReader("BD1.txt");
	FileWriter writer = new FileWriter("BD1.txt");
	
	List<String[]> minhasEntradas = reader.readAll();
	List<Cachorro> cachorros = new ArrayList <Cachorro>();
	
/*	ArrayList<Cachorro> listaDeCaes = new ArrayList<Cachorro>();
	Scanner ler = new Scanner(System.in);
	String BD1 = ler.nextLine();
	
*/
	/*for (String[] strings : minhasEntradas) {
		Cachorro c = new Cachorro(strings);
	    cachorros.add(c);
	}
	/*for (int i = 0; i < 74; i++) {
		try {

			FileReader arq = new FileReader("BancodeDados\\BD1.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
		//	System.out.println(Cachorro.get(i));
			
			
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}

*/
/*	Kmeans kmeans = new Kmeans();	for (int k = 1; k <= 5; k++) {
	    Kmeansresultado resultado = kmeans.calcular(cachorros, k);
	    writer.write("------- Con k=" + k + " aux=" + resultado.getAux()
		    + "-------\n");
	    int i = 0;
	    for (Grupo grupo : resultado.getGrupos()) {
		i++;
		writer.write("-- Grupo " + i + " --\n");
		for (Cachorro cachorro : grupo.getCachorros()) {
		    writer.write(cachorro.toString() + "\n");
		}
		writer.write("\n");
		writer.write(grupo.getCentroide().toString());
		writer.write("\n\n");
	    }
	}
	writer.close();
		}
}*/
/*
public class Rodar{
public static void main(String[] args) throws IOException {
   BufferedReader br = new BufferedReader(new		 
C:\\Users\\user\\ProjetoIA\\ProjetoIA\\src\\BD1.txt   FileReader("C:\\Users\\user\\ProjetoIA\\ProjetoIA\\src\\BD1.txt"));
   String linha = br.readLine();
	  System.out.println();
	  br.close();	
	}
} */

public class Rodar{
	 public static void main(String[] args) {
		 
		 List<Cachorro> cachorros = new ArrayList<Cachorro>();
		 Scanner ler = new Scanner(System.in);
		 
		 for (int i = 0; i < 74; i++) {
		   		    try {
		      FileReader arq = new FileReader("C:\\\\Users\\\\user\\\\ProjetoIA\\\\ProjetoIA\\\\src\\\\BD1.txt");
		      BufferedReader lerArq = new BufferedReader(arq);
		      String linha = lerArq.readLine(); 
		      
		      while (linha != null) {
		        		 
		        linha = lerArq.readLine(); // lê da segunda até a última linha
		      }
		 
		      arq.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }	
		   		    
		 
		    System.out.println();
		  }
		
		 Kmeans kmeans = new Kmeans();	
		 	for (int k = 0; k < 74; k++) {
			    Kmeansresultado resultado = kmeans.calcular(cachorros, k);
			    System.out.println("------- Con k=" + k + " aux=" + resultado.getAux()
				    + "-------\n");
			    int i = 0;
			    for (Grupo grupo : resultado.getGrupos()) {
				i++;
				System.out.println("-- Grupo " + i + " --\n");
				for (Cachorro cachorro : grupo.getCachorros()) {
					System.out.println(cachorro.toString() + "\n");
				}
				System.out.println("\n");
				System.out.println(grupo.getCentroide().toString());
				System.out.println("\n\n");
			    }
			}
		 
			}
}
