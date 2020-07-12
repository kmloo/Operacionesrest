package co.com.ws.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PromedioRequest {

	@SerializedName("numeros")
	private List<Double> numeros;

	public List<Double> getNumeros() {
		if(numeros == null) {
			this.numeros = new ArrayList<>();
		}
		return numeros;
	}

	public void setNumeros(List<Double> numeros) {
		this.numeros = numeros;
	}

}
