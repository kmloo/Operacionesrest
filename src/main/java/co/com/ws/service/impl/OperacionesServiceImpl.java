package co.com.ws.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.com.ws.cliente.soap.OperacionesCliente;
import co.com.ws.entity.Response;
import co.com.ws.service.OperacionesService;
import co.com.wsco.com.ws.util.ValidadorCampos;

@Service
public class OperacionesServiceImpl implements OperacionesService {

	private static final transient Logger logger = Logger.getLogger(OperacionesServiceImpl.class.getName());

	@Autowired
	private OperacionesCliente soapClient;

	/**
	 * Metodo que calcula la pendiente de una recta
	 */
	@Override
	public Response calcularPendiente(Double x1, Double x2, Double y1, Double y2) {
		logger.info("Calculo de pendiente de recta");
		Response res = new Response();
		try {
			res.setRespuesta(soapClient.dividir(soapClient.restar(y2, y1), soapClient.restar(x2, x1)));
			res.setCodigo(HttpStatus.OK.value());
			res.setMensaje("La pendiente de la recta fue calculada exitosamente");
		} catch (Exception e) {
			logger.error("Error calculando la pendiente de la recta ", e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje("Error en el calculo de la pendiente");
		}
		logger.info("Calculo de pendiente exitoso: valor calculado m = " + res.getRespuesta());
		return res;

	}

	/**
	 * Metodo que calcula el promedio de una lista de numeros enviados
	 */
	@Override
	public Response calcularPromedio(List<Double> numeros) {
		logger.info("Calculo de promedio");
		Response res = new Response();
		try {
			List<Double> procesada = ValidadorCampos.procesarLista(numeros);
			if (procesada == null || procesada.isEmpty()) {
				res.setCodigo(HttpStatus.BAD_REQUEST.value());
				res.setMensaje("La lista debe tener numeros diferentes a 0");
			} else {
				Double sumatoria = 0.0;
				for (Double numero : procesada) {
					sumatoria = soapClient.sumar(sumatoria.doubleValue(), numero.doubleValue());
				}

				res.setRespuesta(soapClient.dividir(sumatoria, Double.parseDouble(procesada.size() + "")));
				res.setCodigo(HttpStatus.OK.value());
				res.setMensaje("El promedio fue calculado exitosamente");

			}
		} catch (Exception e) {
			logger.error("Error calculando el promedio ", e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje("Error en el calculo del promedio");
		}
		logger.info("Calculo del promedio exitoso: valor calculado p = " + res.getRespuesta());
		return res;
	}

	/**
	 * Metodo que calcula el area de un triangulo
	 */
	@Override
	public Response calcularAreaTriangulo(Double base, Double altura) {
		logger.info("Calculo del area de un triangulo");
		Response res = new Response();
		try {
			res.setRespuesta(soapClient.dividir(soapClient.multiplicar(base.doubleValue(), altura.doubleValue()), 2D));
			res.setCodigo(HttpStatus.OK.value());
			res.setMensaje("Se ha calculado el area del triangulo correctamente");

		} catch (Exception e) {
			logger.error("Error calculando el area del triangulo ", e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje("Error en el area del triangulo");
		}
		logger.info("Calculo del area exitoso: valor calculado A = " + res.getRespuesta());
		return res;
	}

	/**
	 * Metodo que calcula el area de un circulo
	 */
	@Override
	public Response calcularAreaCirculo(Double radio) {
		logger.info("Calculo del area de un circulo");
		Response res = new Response();
		try {
			res.setRespuesta(soapClient.multiplicar(Math.PI, soapClient.multiplicar(radio.doubleValue(), radio.doubleValue())));
			res.setCodigo(HttpStatus.OK.value());
			res.setMensaje("Se ha calculado el area del circulo correctamente");

		} catch (Exception e) {
			logger.error("Error calculando el area del circulo ", e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje("Error en el area del circulo");
		}
		logger.info("Calculo del area exitoso: valor calculado A = " + res.getRespuesta());
		return res;
	}

}
