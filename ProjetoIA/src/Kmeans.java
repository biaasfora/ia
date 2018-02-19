import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;			//Pontos = Cachorro -> pontos = cachorros
									//Cluster = Grupo -> clusters = grupos
public class Kmeans {
    public Resultado calcular(List<Cachorro> cachorros, Integer k)    {
	List<Grupo> grupos = elegerCentroides(cachorros, k);

	while (!finalizo(grupos)) {
	    prepararGrupos(grupos);
	    OsCachorro(cachorros, grupos);
	    recalcularCentroides(grupos);
	}

	Double aux = calcularGrupos(grupos);

	return new Resultado(grupos, aux);
    }

    private void recalcularCentroides(List<Grupo> grupos) {
	for (Grupo c : grupos) {
	    if (c.getCachorro().isEmpty()) {
		c.setTermino(true);
		continue;
	    }

	    Float[] d = new Float[c.getCachorro().get(0).getLocal()];
	    Arrays.fill(d, 0f);
	    for (Cachorro p : c.getCachorro()) {
		for (int i = 0; i < p.getLocal(); i++) {
		    d[i] += (p.get(i) / c.getCachorro().size());
		}
	    }

	    Cachorro novoCentroide = new Cachorro(d);

	    if (novoCentroide.equals(c.getCentroide())) {
		c.setTermino(true);
	    } else {
		c.setCentroide(novoCentroide);
	    }
	}
    }

    private void elegerCachorros(List<Cachorro> cachorros, List<Grupos> clusters) {
	for (Ponto ponto : pontos) {
	    Cluster maisProximo = clusters.get(0);
	    Double distanciaMinima = Double.MAX_VALUE;
	    for (Cluster cluster : clusters) {
		Double distancia = ponto.distanciaEuclidiana(cluster
			.getCentroide());
		if (distanciaMinima > distancia) {
		    distanciaMinima = distancia;
		    maisProximo = cluster;
		}
	    }
	    maisProximo.getPontos().add(ponto);
	}
    }

    private void prepararClusters(List<Cluster> clusters) {
	for (Cluster c : clusters) {
	    c.limparPontos();
	}
    }

    private Double calcularClusters(List<Cluster> clusters) {
	Double aux = 0d;

	for (Cluster cluster : clusters) {
	    for (Ponto ponto : cluster.getPontos()) {
		aux += ponto.distanciaEuclidiana(cluster.getCentroide());
	    }
	}

	return aux;
    }

    private boolean finalizo(List<Cluster> clusters) {
	for (Cluster cluster : clusters) {
	    if (!cluster.isTermino()) {
		return false;
	    }
	}
	return true;
    }

    private List<Cluster> elegerCentroides(List<Ponto> pontos, Integer k) {
	List<Cluster> centroides = new ArrayList<Cluster>();

	List<Float> maximos = new ArrayList<Float>();
	List<Float> minimos = new ArrayList<Float>();
	// defini máximo e minimo de cada dimensão

	for (int i = 0; i < pontos.get(0).getLocal(); i++) {
	    Float min = Float.POSITIVE_INFINITY, max = Float.NEGATIVE_INFINITY;

	    for (Ponto ponto : pontos) {
		min = min > ponto.get(i) ? ponto.get(0) : min;
		max = max < ponto.get(i) ? ponto.get(i) : max;
	    }

	    maximos.add(max);
	    minimos.add(min);
	}

	Random random = new Random();

		for (int i = 0; i < k; i++) {
		    Float[] data = new Float[ponto.get(0).getLocal()];
		    Arrays.fill(data, 0f);
		    for (int d = 0; d < pontos.get(0).getLocal(); d++) {
			data[d] = random.nextFloat()
				* (maximos.get(d) - minimos.get(d)) + minimos.get(d);
		    }
	
		    Cluster c = new Cluster();
		    Ponto centroide = new Ponto(data);
		    c.setCentroide(centroide);
		    centroides.add(c);
		}
	
		return centroides;
	    }
}


