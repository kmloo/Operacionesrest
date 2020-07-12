package co.com.ws.configuracion;

import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import co.com.ws.cliente.soap.OperacionesCliente;

@Configuration
public class Configuracion {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("co.com.ws.cliente.entity");
		return marshaller;
	}

	@Bean
	public OperacionesCliente soapClient(Jaxb2Marshaller marshaller) {
		ResourceBundle application = ResourceBundle.getBundle("application");
		OperacionesCliente client = new OperacionesCliente();
		client.setDefaultUri(application.getString("url_operaciones_wsdl"));
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
