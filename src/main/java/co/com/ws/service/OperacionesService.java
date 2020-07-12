package co.com.ws.service;

import java.util.List;

import co.com.ws.entity.Response;

public interface OperacionesService {
	
	Response calcularPendiente(Double x1, Double x2, Double y1, Double y2);
	
	Response calcularPromedio(List<Double> numeros);
	
	Response calcularAreaTriangulo(Double base, Double altura);
	
	Response calcularAreaCirculo(Double radio);

}
