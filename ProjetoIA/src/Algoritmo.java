/*
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Algoritmo {

	Cachorro centroide1 = new Cachorro(9, 3, 2, 3, 4, 4, 3, 4, 4, 5, 4, 4);
	Cachorro centroide2 = new Cachorro(27, 1, 5, 4, 4, 2, 3, 3, 4, 3, 6, 2);
	Cachorro centroide3 = new Cachorro(34, 1, 6, 6, 4, 2, 6, 6, 5, 5, 6, 1);
	Cachorro centroide4 = new Cachorro(59, 1, 5, 5, 6, 6, 1, 3, 6, 1, 1, 2);

	// grupos definidos de cada centroide
	ArrayList<Cachorro> grupo1 = null;
	ArrayList<Cachorro> grupo2 = null;
	ArrayList<Cachorro> grupo3 = null;
	ArrayList<Cachorro> grupo4 = null;

	public static void main(String[] args) {

		float raca;
		float porte;
		float energia;
		float brincalhao;
		float sociavelComCaes;
		float sociavelComEstranhos;
		float protecao;
		float necessidadeDeExercicio;
		float apegoAoDono;
		float facilidadeDeTreinamento;
		float guarda;
		float higiene;

		ArrayList<Cachorro> listaDeCaes = new ArrayList<Cachorro>();
		Scanner ler = new Scanner(System.in);
		String BD1 = ler.nextLine();

		for (int i = 0; i < 74; i++) {
			try {

				FileReader arq = new FileReader(BD1);
				BufferedReader lerArq = new BufferedReader(arq);
				String linha = lerArq.readLine();

				raca = (float) Integer.parseInt(linha.substring(0, 2)) * (1 / 100);
				porte = (float) Integer.parseInt(linha.substring(3, 4)) * (1 / 100);
				energia = (float) Integer.parseInt(linha.substring(5, 6)) * (1 / 100);
				brincalhao = (float) Integer.parseInt(linha.substring(7, 8)) * (1 / 100);
				sociavelComCaes = (float) Integer.parseInt(linha.substring(9, 10)) * (1 / 100);
				sociavelComEstranhos = (float) Integer.parseInt(linha.substring(11, 12)) * (1 / 100);
				protecao = (float) Integer.parseInt(linha.substring(13, 14)) * (1 / 100);
				necessidadeDeExercicio = (float) Integer.parseInt(linha.substring(15, 16)) * (1 / 100);
				apegoAoDono = (float) Integer.parseInt(linha.substring(17, 18)) * (1 / 100);
				facilidadeDeTreinamento = (float) Integer.parseInt(linha.substring(19, 20)) * (1 / 100);
				guarda = (float) Integer.parseInt(linha.substring(21, 22)) * (1 / 100);
				higiene = (float) Integer.parseInt(linha.substring(23, 24)) * (1 / 100);

				Cachorro dog = new Cachorro(raca, porte, energia, brincalhao, sociavelComCaes, sociavelComEstranhos,
						protecao, necessidadeDeExercicio, apegoAoDono, facilidadeDeTreinamento, guarda, higiene);
				listaDeCaes.add(dog);

			} catch (IOException e) {
				System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			}
		}

	}

	// meus centroides
	public void centroides(ArrayList<Cachorro> dogs) {

		for (int x = 0; x < dogs.size(); x++) {
			float porte = dogs.get(x).getPorte();
			float energia = dogs.get(x).getEnergia();
			float brincalhao = dogs.get(x).getBrincalhao();
			float sociavelComCaes = dogs.get(x).getSociavelComCaes();
			float sociavelComEstranhos = dogs.get(x).getSociavelComEstranhos();
			float protecao = dogs.get(x).getProtecao();
			float necessidadeDeExercicio = dogs.get(x).getNecessidadeDeExercicio();
			float apegoAoDono = dogs.get(x).getApegoAoDono();
			float facilidadeDeTreinamento = dogs.get(x).getFacilidadeDeTreinamento();
			float guarda = dogs.get(x).getGuarda();
			float higiene = dogs.get(x).getHigiene();
		}

	}

	public void calculaPorte(float atributo, ArrayList<Cachorro> dogs, int x) {

		float aux1 = (float) Math.pow((atributo - centroide1.getPorte()), 2);
		float aux2 = (float) Math.pow((atributo - centroide2.getPorte()), 2);
		float aux3 = (float) Math.pow((atributo - centroide3.getPorte()), 2);
		float aux4 = (float) Math.pow((atributo - centroide4.getPorte()), 2);
		// contadores dos centroides

		int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
		// comparações com todos os centroides

		if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
			c1++;
		} else if (aux2 < aux3 && aux2 < aux4) {
			c2++;
		} else if (aux3 < aux4) {
			c3++;
		} else {
			c4++;
		}

		// adicionando ao contador
		
		if (c1 > c2 && c1 > c3 && c1 > c4) {
			grupo1.add(dogs.get(x));
		} else if (c2 > c3 && c2 > c4) {
			grupo2.add(dogs.get(x));
		} else if (c3 > c4) 		{
			grupo3.add(dogs.get(x));
		} else
			grupo4.add(dogs.get(x));

	}
	
	public void calculaEnergia(float atributo, ArrayList<Cachorro> dogs, int x) {

		float aux1 = (float) Math.pow((atributo - centroide1.getEnergia()), 2);
		float aux2 = (float) Math.pow((atributo - centroide2.getEnergia()), 2);
		float aux3 = (float) Math.pow((atributo - centroide3.getEnergia()), 2);
		float aux4 = (float) Math.pow((atributo - centroide4.getEnergia()), 2);
		// contadores dos centroides

		int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
		// comparações com todos os centroides

		if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
			c1++;
		} else if (aux2 < aux3 && aux2 < aux4) {
			c2++;
		} else if (aux3 < aux4) {
			c3++;
		} else {
			c4++;
		}

		// adicionando ao contador
		
		if (c1 > c2 && c1 > c3 && c1 > c4) {
			grupo1.add(dogs.get(x));
		} else if (c2 > c3 && c2 > c4) {
			grupo2.add(dogs.get(x));
		} else if (c3 > c4) 		{
			grupo3.add(dogs.get(x));
		} else
			grupo4.add(dogs.get(x));

	}
	public void calculaBrincalhao(float atributo, ArrayList<Cachorro> dogs, int x) {

		float aux1 = (float) Math.pow((atributo - centroide1.getBrincalhao()), 2);
		float aux2 = (float) Math.pow((atributo - centroide2.getBrincalhao()), 2);
		float aux3 = (float) Math.pow((atributo - centroide3.getBrincalhao()), 2);
		float aux4 = (float) Math.pow((atributo - centroide4.getBrincalhao()), 2);
		// contadores dos centroides

		int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
		// comparações com todos os centroides

		if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
			c1++;
		} else if (aux2 < aux3 && aux2 < aux4) {
			c2++;
		} else if (aux3 < aux4) {
			c3++;
		} else {
			c4++;
		}

		// adicionando ao contador
		
		if (c1 > c2 && c1 > c3 && c1 > c4) {
			grupo1.add(dogs.get(x));
		} else if (c2 > c3 && c2 > c4) {
			grupo2.add(dogs.get(x));
		} else if (c3 > c4) 		{
			grupo3.add(dogs.get(x));
		} else
			grupo4.add(dogs.get(x));

	}
	public void calculaSociavelComCaes(float atributo, ArrayList<Cachorro> dogs, int x) {

		float aux1 = (float) Math.pow((atributo - centroide1.getSociavelComCaes()), 2);
		float aux2 = (float) Math.pow((atributo - centroide2.getSociavelComCaes()), 2);
		float aux3 = (float) Math.pow((atributo - centroide3.getSociavelComCaes()), 2);
		float aux4 = (float) Math.pow((atributo - centroide4.getSociavelComCaes()), 2);
		// contadores dos centroides

		int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
		// comparações com todos os centroides

		if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
			c1++;
		} else if (aux2 < aux3 && aux2 < aux4) {
			c2++;
		} else if (aux3 < aux4) {
			c3++;
		} else {
			c4++;
		}

		// adicionando ao contador
		
		if (c1 > c2 && c1 > c3 && c1 > c4) {
			grupo1.add(dogs.get(x));
		} else if (c2 > c3 && c2 > c4) {
			grupo2.add(dogs.get(x));
		} else if (c3 > c4) 		{
			grupo3.add(dogs.get(x));
		} else
			grupo4.add(dogs.get(x));

	}

	public void calculaSociavelComEstranhos(float atributo, ArrayList<Cachorro> dogs, int x) {

		float aux1 = (float) Math.pow((atributo - centroide1.getSociavelComEstranhos()), 2);
		float aux2 = (float) Math.pow((atributo - centroide2.getSociavelComEstranhos()), 2);
		float aux3 = (float) Math.pow((atributo - centroide3.getSociavelComEstranhos()), 2);
		float aux4 = (float) Math.pow((atributo - centroide4.getSociavelComEstranhos()), 2);
		// contadores dos centroides

		int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
		// comparações com todos os centroides

		if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
			c1++;
		} else if (aux2 < aux3 && aux2 < aux4) {
			c2++;
		} else if (aux3 < aux4) {
			c3++;
		} else {
			c4++;
		}

		// adicionando ao contador
		
		if (c1 > c2 && c1 > c3 && c1 > c4) {
			grupo1.add(dogs.get(x));
		} else if (c2 > c3 && c2 > c4) {
			grupo2.add(dogs.get(x));
		} else if (c3 > c4) 		{
			grupo3.add(dogs.get(x));
		} else
			grupo4.add(dogs.get(x));

	}

	public void calculaProtecao(float atributo, ArrayList<Cachorro> dogs, int x) {

		float aux1 = (float) Math.pow((atributo - centroide1.getProtecao()), 2);
		float aux2 = (float) Math.pow((atributo - centroide2.getProtecao()), 2);
		float aux3 = (float) Math.pow((atributo - centroide3.getProtecao()), 2);
		float aux4 = (float) Math.pow((atributo - centroide4.getProtecao()), 2);
		// contadores dos centroides

		int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
		// comparações com todos os centroides

		if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
			c1++;
		} else if (aux2 < aux3 && aux2 < aux4) {
			c2++;
		} else if (aux3 < aux4) {
			c3++;
		} else {
			c4++;
		}

		// adicionando ao contador
		
		if (c1 > c2 && c1 > c3 && c1 > c4) {
			grupo1.add(dogs.get(x));
		} else if (c2 > c3 && c2 > c4) {
			grupo2.add(dogs.get(x));
		} else if (c3 > c4) 		{
			grupo3.add(dogs.get(x));
		} else
			grupo4.add(dogs.get(x));

	}

		public void calculaNecessidadeDeExercicio(float atributo, ArrayList<Cachorro> dogs, int x) {
	
			float aux1 = (float) Math.pow((atributo - centroide1.getNecessidadeDeExercicio()), 2);
			float aux2 = (float) Math.pow((atributo - centroide2.getNecessidadeDeExercicio()), 2);
			float aux3 = (float) Math.pow((atributo - centroide3.getNecessidadeDeExercicio()), 2);
			float aux4 = (float) Math.pow((atributo - centroide4.getNecessidadeDeExercicio()), 2);
			// contadores dos centroides
	
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			// comparações com todos os centroides
	
			if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
				c1++;
			} else if (aux2 < aux3 && aux2 < aux4) {
				c2++;
			} else if (aux3 < aux4) {
				c3++;
			} else {
				c4++;
			}
	
			// adicionando ao contador
			
			if (c1 > c2 && c1 > c3 && c1 > c4) {
				grupo1.add(dogs.get(x));
			} else if (c2 > c3 && c2 > c4) {
				grupo2.add(dogs.get(x));
			} else if (c3 > c4) 		{
				grupo3.add(dogs.get(x));
			} else
				grupo4.add(dogs.get(x));
	
		}
		public void calculaApegoAoDono(float atributo, ArrayList<Cachorro> dogs, int x) {
			
			float aux1 = (float) Math.pow((atributo - centroide1.getApegoAoDono()), 2);
			float aux2 = (float) Math.pow((atributo - centroide2.getApegoAoDono()), 2);
			float aux3 = (float) Math.pow((atributo - centroide3.getApegoAoDono()), 2);
			float aux4 = (float) Math.pow((atributo - centroide4.getApegoAoDono()), 2);
			// contadores dos centroides
	
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			// comparações com todos os centroides
	
			if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
				c1++;
			} else if (aux2 < aux3 && aux2 < aux4) {
				c2++;
			} else if (aux3 < aux4) {
				c3++;
			} else {
				c4++;
			}
	
			// adicionando ao contador
			
			if (c1 > c2 && c1 > c3 && c1 > c4) {
				grupo1.add(dogs.get(x));
			} else if (c2 > c3 && c2 > c4) {
				grupo2.add(dogs.get(x));
			} else if (c3 > c4) 		{
				grupo3.add(dogs.get(x));
			} else
				grupo4.add(dogs.get(x));
	
		}

		public void calculaFacilidadeDeTreinamento(float atributo, ArrayList<Cachorro> dogs, int x) {
			
			float aux1 = (float) Math.pow((atributo - centroide1.getFacilidadeDeTreinamento()), 2);
			float aux2 = (float) Math.pow((atributo - centroide2.getFacilidadeDeTreinamento()), 2);
			float aux3 = (float) Math.pow((atributo - centroide3.getFacilidadeDeTreinamento()), 2);
			float aux4 = (float) Math.pow((atributo - centroide4.getFacilidadeDeTreinamento()), 2);
			// contadores dos centroides
	
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			// comparações com todos os centroides
	
			if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
				c1++;
			} else if (aux2 < aux3 && aux2 < aux4) {
				c2++;
			} else if (aux3 < aux4) {
				c3++;
			} else {
				c4++;
			}
	
			// adicionando ao contador
			
			if (c1 > c2 && c1 > c3 && c1 > c4) {
				grupo1.add(dogs.get(x));
			} else if (c2 > c3 && c2 > c4) {
				grupo2.add(dogs.get(x));
			} else if (c3 > c4) 		{
				grupo3.add(dogs.get(x));
			} else
				grupo4.add(dogs.get(x));
	
		}

		public void calculaGuarda(float atributo, ArrayList<Cachorro> dogs, int x) {
			
			float aux1 = (float) Math.pow((atributo - centroide1.getGuarda()), 2);
			float aux2 = (float) Math.pow((atributo - centroide2.getGuarda()), 2);
			float aux3 = (float) Math.pow((atributo - centroide3.getGuarda()), 2);
			float aux4 = (float) Math.pow((atributo - centroide4.getGuarda()), 2);
			// contadores dos centroides
	
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			// comparações com todos os centroides
	
			if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
				c1++;
			} else if (aux2 < aux3 && aux2 < aux4) {
				c2++;
			} else if (aux3 < aux4) {
				c3++;
			} else {
				c4++;
			}
	
			// adicionando ao contador
			
			if (c1 > c2 && c1 > c3 && c1 > c4) {
				grupo1.add(dogs.get(x));
			} else if (c2 > c3 && c2 > c4) {
				grupo2.add(dogs.get(x));
			} else if (c3 > c4) 		{
				grupo3.add(dogs.get(x));
			} else
				grupo4.add(dogs.get(x));
	
		}
public void calculaHigiene(float atributo, ArrayList<Cachorro> dogs, int x) {
			
			float aux1 = (float) Math.pow((atributo - centroide1.getHigiene()), 2);
			float aux2 = (float) Math.pow((atributo - centroide2.getHigiene()), 2);
			float aux3 = (float) Math.pow((atributo - centroide3.getHigiene()), 2);
			float aux4 = (float) Math.pow((atributo - centroide4.getHigiene()), 2);
			// contadores dos centroides
	
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
			// comparações com todos os centroides
	
			if (aux1 < aux2 && aux1 < aux3 && aux1 < aux4) {
				c1++;
			} else if (aux2 < aux3 && aux2 < aux4) {
				c2++;
			} else if (aux3 < aux4) {
				c3++;
			} else {
				c4++;
			}
	
			// adicionando ao contador
			
			if (c1 > c2 && c1 > c3 && c1 > c4) {
				grupo1.add(dogs.get(x));
			} else if (c2 > c3 && c2 > c4) {
				grupo2.add(dogs.get(x));
			} else if (c3 > c4) 		{
				grupo3.add(dogs.get(x));
			} else
				grupo4.add(dogs.get(x));
	
		}

}
*/