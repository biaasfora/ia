import java.util.ArrayList;
import java.util.List;
	
public class Kmeansresultado {
	

	    private List<Grupo> grupos = new ArrayList<Grupo>();
	    private Double aux;

	    public Kmeansresultado(List<Grupo> clusters, Double aux) {
		super();
		this.aux = aux;
		this.grupos = grupos;
	    }

	    public List<Grupo> getGrupo() {
		return grupos;
	    }

	    public Double getAux() {
		return aux;
	    }
	}

