import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Kmeans {
    public Kmeansresultado calcular(List<Cachorro> cachorros, Integer k) {
	List<Grupo> grupos = elegerCentroides(cachorros, k);

	while (!finalizo(grupos)) {
	    prepararGrupos(grupos);
	    atribuirCachorros(cachorros, grupos);
	    recalcularCentroides(grupos);
	}

	Double aux = calcularFuncionObjetivo(grupos);

	return new Kmeansresultado(grupos, aux);
    }

    private void recalcularCentroides(List<Grupo> grupos) {
	for (Grupo g : grupos) {
	    if (g.getCachorros().isEmpty()) {
		g.setTermino(true);
		continue;
	    }

	    Float[] d = new Float[g.getCachorros().get(0).getGrau()];
	    Arrays.fill(d, 0f);
	    for (Cachorro c : g.getCachorros()) {
		for (int i = 0; i < c.getGrau(); i++) {
		    d[i] += (c.get(i) / g.getCachorros().size());
		}
	    }

	    Cachorro novoCentroide = new Cachorro(d);

	    if (novoCentroide.equals(g.getCentroide())) {
		g.setTermino(true);
	    } else {
		g.setCentroide(novoCentroide);
	    }
	}
    }

    private void atribuirCachorros(List<Cachorro> cachorros, List<Grupo> grupos) {
	for (Cachorro cachorro : cachorros) {
	    Grupo maisPerto = grupos.get(0);
	    Double distanciaMinima = Double.MAX_VALUE;
	    for (Grupo grupo : grupos) {
		Double distancia = cachorro.distanciaEuclideana(grupo.getCentroide());
		if (distanciaMinima > distancia) {
		    distanciaMinima = distancia;
		    maisPerto = grupo;
		}
	    }
	    maisPerto.getCachorros().add(cachorro);
	}
    }

    private void prepararGrupos(List<Grupo> grupos) {
	for (Grupo g : grupos) {
	    g.limparCachorros();
	}
    }

    private Double calcularFuncionObjetivo(List<Grupo> grupos) {
	Double aux = 0d;

	for (Grupo grupo : grupos) {
	    for (Cachorro cachorro : grupo.getCachorros()) {
		aux += cachorro.distanciaEuclideana(grupo.getCentroide());
	    }
	}

	return aux;
    }

    private boolean finalizo(List<Grupo> grupos) {
	for (Grupo grupo : grupos) {
	    if (!grupo.isTermino()) {
		return false;
	    }
	}
	return true;
    }

    private List<Grupo> elegerCentroides(List<Cachorro> cachorros, Integer k) {
	List<Grupo> centroides = new ArrayList<Grupo>();

	List<Float> maximos = new ArrayList<Float>();
	List<Float> minimos = new ArrayList<Float>();
	// me fijo máximo y mínimo de cada dimensión

	for (int i = 0; i < cachorros.get(0).getGrau(); i++) {
	    Float min = Float.POSITIVE_INFINITY, max = Float.NEGATIVE_INFINITY;

	    for (Cachorro cachorro : cachorros) {
		min = min > cachorro.get(i) ? cachorro.get(0) : min;
		max = max < cachorro.get(i) ? cachorro.get(i) : max;
	    }

	    maximos.add(max);
	    minimos.add(min);
	}

	Random random = new Random();

	for (int i = 0; i < k; i++) {
	    Float[] data = new Float[cachorros.get(0).getGrau()];
	    Arrays.fill(data, 0f);
	    for (int d = 0; d < cachorros.get(0).getGrau(); d++) {
		data[d] = random.nextFloat()
			* (maximos.get(d) - minimos.get(d)) + minimos.get(d);
	    }

	    Grupo g = new Grupo();
	    Cachorro centroide = new Cachorro(data);
	    g.setCentroide(centroide);
	    centroides.add(g);
	}

	return centroides;
    }
}
