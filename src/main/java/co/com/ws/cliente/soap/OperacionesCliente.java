package co.com.ws.cliente.soap;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import co.com.ws.cliente.entity.Division;
import co.com.ws.cliente.entity.DivisionResponse;
import co.com.ws.cliente.entity.Multiplicacion;
import co.com.ws.cliente.entity.MultiplicacionResponse;
import co.com.ws.cliente.entity.Resta;
import co.com.ws.cliente.entity.RestaResponse;
import co.com.ws.cliente.entity.Suma;
import co.com.ws.cliente.entity.SumaResponse;

@Service
@Component("OperacionesCliente")
public class OperacionesCliente extends WebServiceGatewaySupport {

	private static final transient Logger logger = Logger.getLogger(OperacionesCliente.class.getName());

	public OperacionesCliente() {

	}

	/**
	 * LLamado a el metodo sumar del servicio soap
	 * 
	 * @param parametro1
	 * @param parametro2
	 * @return
	 * @throws Exception
	 */
	public Double sumar(Double parametro1, Double parametro2) throws Exception {
		Suma request = new Suma();
		try {

			request.setParametro1(parametro1);
			request.setParametro2(parametro2);

			JAXBElement<SumaResponse> response = (JAXBElement<SumaResponse>) getWebServiceTemplate()
					.marshalSendAndReceive(request);

			return response.getValue() != null
					? response.getValue().getReturn() != null ? response.getValue().getReturn().getRespuesta() : null
					: null;

		} catch (Exception e) {
			logger.info("Error ejecutando la suma ", e);
			throw new Exception(e);
		}

	}

	/**
	 * LLamado a el metodo restar del servicio soap
	 * 
	 * @param parametro1
	 * @param parametro2
	 * @return
	 * @throws Exception
	 */
	public Double restar(Double parametro1, Double parametro2) throws Exception {
		Resta request = new Resta();
		try {

			request.setParametro1(parametro1);
			request.setParametro2(parametro2);

			JAXBElement<RestaResponse> response = (JAXBElement<RestaResponse>) getWebServiceTemplate()
					.marshalSendAndReceive(request);

			return response.getValue() != null
					? response.getValue().getReturn() != null ? response.getValue().getReturn().getRespuesta() : null
					: null;

		} catch (Exception e) {
			logger.info("Error ejecutando la resta ", e);
			throw new Exception(e);
		}

	}

	/**
	 * LLamado a el metodo multiplicacion del servicio soap
	 * 
	 * @param parametro1
	 * @param parametro2
	 * @return
	 * @throws Exception
	 */
	public Double multiplicar(Double parametro1, Double parametro2) throws Exception {
		Multiplicacion request = new Multiplicacion();
		try {

			request.setParametro1(parametro1);
			request.setParametro2(parametro2);

			JAXBElement<MultiplicacionResponse> response = (JAXBElement<MultiplicacionResponse>) getWebServiceTemplate()
					.marshalSendAndReceive(request);

			return response.getValue() != null
					? response.getValue().getReturn() != null ? response.getValue().getReturn().getRespuesta() : null
					: null;

		} catch (Exception e) {
			logger.info("Error ejecutando la multiplicacion ", e);
			throw new Exception(e);
		}
	}

	/**
	 * LLamado a el metodo division del servicio soap
	 * 
	 * @param parametro1
	 * @param parametro2
	 * @return
	 * @throws Exception
	 */
	public Double dividir(Double parametro1, Double parametro2) throws Exception {
		Division request = new Division();
		try {

			request.setParametro1(parametro1);
			request.setParametro2(parametro2);

			JAXBElement<DivisionResponse> response = (JAXBElement<DivisionResponse>) getWebServiceTemplate()
					.marshalSendAndReceive(request);

			return response.getValue() != null
					? response.getValue().getReturn() != null ? response.getValue().getReturn().getRespuesta() : null
					: null;

		} catch (Exception e) {
			logger.info("Error ejecutando la division ", e);
			throw new Exception(e);
		}

	}

}
