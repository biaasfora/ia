import java.util.ArrayList;
import java.util.List;

public class Grupo {

    private List<Cachorro> cachorros = new ArrayList<Cachorro>();
    private Cachorro centroide;
    private boolean termino = false;

    public Cachorro getCentroide() {
	return centroide;
    }

    public void setCentroide(Cachorro centroide) {
	this.centroide = centroide;
    }

    public List<Cachorro> getCachorros() {
	return cachorros;
    }

    public boolean isTermino() {
	return termino;
    }

    public void setTermino(boolean termino) {
	this.termino = termino;
    }

    public void limparCachorros() {
	cachorros.clear();
    }

    @Override
    public String toString() {
	return centroide.toString();
    }
}