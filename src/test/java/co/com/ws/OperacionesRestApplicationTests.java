package co.com.ws;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ws.cliente.soap.OperacionesCliente;
import co.com.ws.entity.Response;
import co.com.ws.service.OperacionesService;

@SpringBootTest
class OperacionesRestApplicationTests {

	@Autowired
	private OperacionesCliente soapClient;

	@Autowired
	private OperacionesService operacionesService;

	@Test
	void dividirLoad() throws Exception {
		Double respuesta = soapClient.dividir(2.0, 5.1);
		assertThat(respuesta).isNotNull();
	}

	@Test
	void sumarLoad() throws Exception {
		Double respuesta = soapClient.sumar(2.0, 5.1);
		assertThat(respuesta).isNotNull();
	}

	@Test
	void mutiplicarLoad() throws Exception {
		Double respuesta = soapClient.multiplicar(2.0, 5.1);
		assertThat(respuesta).isNotNull();
	}

	@Test
	void restarLoad() throws Exception {
		Double respuesta = soapClient.restar(2.0, 5.1);
		assertThat(respuesta).isNotNull();
	}

	@Test
	void pendienteLoad() throws Exception {
		Response respuesta = operacionesService.calcularPendiente(2.1, 1.0, 3.0, 2.0);
		assertThat(respuesta.getRespuesta()).isNotNull();
	}

	@Test
	void promedioeLoad() throws Exception {
		List<Double> numeros = new ArrayList<>();
		numeros.add(2.5);
		numeros.add(5D);
		numeros.add(15D);
		numeros.add(0D);
		Response respuesta = operacionesService.calcularPromedio(numeros);
		assertThat(respuesta.getRespuesta()).isNotNull();
	}
	
	@Test
	void areaTrianguloLoad() throws Exception {
		Response respuesta = operacionesService.calcularAreaTriangulo(3.0, 2.0);
		assertThat(respuesta.getRespuesta()).isNotNull();
	}

	@Test
	void areaCirculooLoad() throws Exception {
		Response respuesta = operacionesService.calcularAreaCirculo(1.5);
		assertThat(respuesta.getRespuesta()).isNotNull();
	}
	
}
