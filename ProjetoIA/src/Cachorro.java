/*
public class Cachorro {

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
	
	public Cachorro(float raca, float porte, float energia, float brincalhao, float sociavelComCaes,
			float sociavelComEstranhos, float protecao, float necessidadeDeExercicio, float apegoAoDono,
			float facilidadeDeTreinamento, float guarda, float higiene) {
		
		this.raca = raca;
		this.porte = porte;
		this.energia = energia;
		this.brincalhao = brincalhao;
		this.sociavelComCaes = sociavelComCaes;
		this.sociavelComEstranhos = sociavelComEstranhos;
		this.protecao = protecao;
		this.necessidadeDeExercicio = necessidadeDeExercicio;
		this.apegoAoDono = apegoAoDono;
		this.facilidadeDeTreinamento = facilidadeDeTreinamento;
		this.guarda = guarda;
		this.higiene = higiene;
	}

	public float getRaca() {
		return raca;
	}

	public void setRaca(float raca) {
		this.raca = raca;
	}

	public float getPorte() {
		return porte;
	}

	public void setPorte(float porte) {
		this.porte = porte;
	}

	public float getEnergia() {
		return energia;
	}

	public void setEnergia(float energia) {
		this.energia = energia;
	}

	public float getBrincalhao() {
		return brincalhao;
	}

	public void setBrincalhao(float brincalhao) {
		this.brincalhao = brincalhao;
	}

	public float getSociavelComCaes() {
		return sociavelComCaes;
	}

	public void setSociavelComCaes(float sociavelComCaes) {
		this.sociavelComCaes = sociavelComCaes;
	}

	public float getSociavelComEstranhos() {
		return sociavelComEstranhos;
	}

	public void setSociavelComEstranhos(float sociavelComEstranhos) {
		this.sociavelComEstranhos = sociavelComEstranhos;
	}

	public float getProtecao() {
		return protecao;
	}

	public void setProtecao(float protecao) {
		this.protecao = protecao;
	}

	public float getNecessidadeDeExercicio() {
		return necessidadeDeExercicio;
	}

	public void setNecessidadeDeExercicio(float necessidadeDeExercicio) {
		this.necessidadeDeExercicio = necessidadeDeExercicio;
	}

	public float getApegoAoDono() {
		return apegoAoDono;
	}

	public void setApegoAoDono(float apegoAoDono) {
		this.apegoAoDono = apegoAoDono;
	}

	public float getFacilidadeDeTreinamento() {
		return facilidadeDeTreinamento;
	}

	public void setFacilidadeDeTreinamento(float facilidadeDeTreinamento) {
		this.facilidadeDeTreinamento = facilidadeDeTreinamento;
	}

	public float getGuarda() {
		return guarda;
	}

	public void setGuarda(float guarda) {
		this.guarda = guarda;
	}

	public float getHigiene() {
		return higiene;
	}

	public void setHigiene(float higiene) {
		this.higiene = higiene;
	}
	
	
}
*/

import java.util.ArrayList;
import java.util.List;

public class Cachorro {
    private Float[] data;

    public Cachorro(String[] strings) {
	super();
	List<Float> cachorros = new ArrayList<Float>();
	for (String string : strings) {
	    cachorros.add(Float.parseFloat(string));
	}
	this.data = cachorros.toArray(new Float[strings.length]);
    }

    public Cachorro(Float[] data) {
	this.data = data;
    }

    public float get(int dimension) {
	return data[dimension];
    }

    public int getGrau() {
	return data.length;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(data[0]);
	for (int i = 1; i < data.length; i++) {
	    sb.append(", ");
	    sb.append(data[i]);
	}
	return sb.toString();
    }

    public Double distanciaEuclideana(Cachorro destino) {
	Double d = 0d;
	for (int i = 0; i < data.length; i++) {
	    d += Math.pow(data[i] - destino.get(i), 2);
	}
	return Math.sqrt(d);
    }

    @Override
    public boolean equals(Object obj) {
	Cachorro other = (Cachorro) obj;
	for (int i = 0; i < data.length; i++) {
	    if (data[i] != other.get(i)) {
		return false;
	    }
	}
	return true;
    }
}