package co.com.ws;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.com.ws.cliente.soap.OperacionesCliente;
import co.com.ws.entity.PromedioRequest;
import co.com.ws.entity.Response;
import co.com.ws.service.OperacionesService;
import co.com.wsco.com.ws.util.ValidadorCampos;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/" })
public class OperacionesController {

	@Autowired
	private OperacionesCliente soapClient;

	@Autowired
	private OperacionesService operacionesService;

	/**
	 * Variable de entrada y salida de datos
	 */
	private static final Gson gson = new Gson();

	private static final transient Logger logger = Logger.getLogger(OperacionesCliente.class.getName());

	/**
	 * Metodo que ejecuta la suma de dos numeros
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ResponseEntity<String> operacion(@RequestParam("number1") Double number1,
			@RequestParam("number2") Double number2) {
		String nombreMetodo = new Object() {
		}.getClass().getEnclosingMethod().getName();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
		Response res = new Response();
		logger.info("Ejecucion " + nombreMetodo + "[ parametro1: " + number1 + ", parametro2: " + number2 + "] ");
		try {
			if (ValidadorCampos.validarCampos(number1, number2)) {
				res.setRespuesta(soapClient.sumar(number1, number2));
				res.setCodigo(HttpStatus.OK.value());
				res.setMensaje(HttpStatus.OK.getReasonPhrase());
			} else {
				res.setCodigo(HttpStatus.BAD_REQUEST.value());
				res.setMensaje("Los numeros no deben estar vacios.");
			}
		} catch (Exception e) {
			logger.error("Error ejecutando " + nombreMetodo, e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		String salida = gson.toJson(res);
		logger.info("Respuesta metodo: " + nombreMetodo + ": " + salida);
		return new ResponseEntity<>(salida, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Metodo que ejecuta la resta de dos numeros
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	@RequestMapping(value = "/subtraction", method = RequestMethod.GET)
	public ResponseEntity<String> restar(@RequestParam("number1") Double number1,
			@RequestParam("number2") Double number2) {
		String nombreMetodo = new Object() {
		}.getClass().getEnclosingMethod().getName();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
		Response res = new Response();
		logger.info("Ejecucion " + nombreMetodo + "[ parametro1: " + number1 + ", parametro2: " + number2 + "] ");
		try {
			if (ValidadorCampos.validarCampos(number1, number2)) {
				res.setRespuesta(soapClient.restar(number1, number2));
				res.setCodigo(HttpStatus.OK.value());
				res.setMensaje(HttpStatus.OK.getReasonPhrase());
			} else {
				res.setCodigo(HttpStatus.BAD_REQUEST.value());
				res.setMensaje("Los numeros no deben estar vacios.");
			}
		} catch (Exception e) {
			logger.error("Error ejecutando " + nombreMetodo, e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		String salida = gson.toJson(res);
		logger.info("Respuesta metodo: " + nombreMetodo + ": " + salida);
		return new ResponseEntity<>(salida, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Metodo que ejecuta la division d edos numeros
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	@RequestMapping(value = "/division", method = RequestMethod.GET)
	public ResponseEntity<String> division(@RequestParam("divider") Double divider,
			@RequestParam("dividend") Double dividend) {
		String nombreMetodo = new Object() {
		}.getClass().getEnclosingMethod().getName();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
		Response res = new Response();
		logger.info("Ejecucion " + nombreMetodo + "[ parametro1: " + divider + ", parametro2: " + dividend + "] ");
		try {
			if (ValidadorCampos.validarCamposDivision(divider, dividend)) {
				res.setRespuesta(soapClient.dividir(divider, dividend));
				res.setCodigo(HttpStatus.OK.value());
				res.setMensaje(HttpStatus.OK.getReasonPhrase());
			} else {
				res.setCodigo(HttpStatus.BAD_REQUEST.value());
				res.setMensaje("Los numeros no deben estar vacios, o el dividendo no debe ser cero.");
			}
		} catch (Exception e) {
			logger.error("Error ejecutando " + nombreMetodo, e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		String salida = gson.toJson(res);
		logger.info("Respuesta metodo: " + nombreMetodo + ": " + salida);
		return new ResponseEntity<>(salida, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Metodo que ejecuta la multiplicaicon de dos numeros
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	@RequestMapping(value = "/multiplication", method = RequestMethod.GET)
	public ResponseEntity<String> multiplicacion(@RequestParam("number1") Double number1,
			@RequestParam("number2") Double number2) {
		String nombreMetodo = new Object() {
		}.getClass().getEnclosingMethod().getName();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
		Response res = new Response();
		logger.info("Ejecucion " + nombreMetodo + "[ parametro1: " + number1 + ", parametro2: " + number2 + "] ");
		try {
			if (ValidadorCampos.validarCampos(number1, number2)) {
				res.setRespuesta(soapClient.multiplicar(number1, number2));
				res.setCodigo(HttpStatus.OK.value());
				res.setMensaje(HttpStatus.OK.getReasonPhrase());
			} else {
				res.setCodigo(HttpStatus.BAD_REQUEST.value());
				res.setMensaje("Los numeros no deben estar vacios.");
			}
		} catch (Exception e) {
			logger.error("Error ejecutando " + nombreMetodo, e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		String salida = gson.toJson(res);
		logger.info("Respuesta metodo: " + nombreMetodo + ": " + salida);
		return new ResponseEntity<>(salida, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Metodo que calcula la pendiente de una recta
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	@RequestMapping(value = "/slope", method = RequestMethod.GET)
	public ResponseEntity<String> pendiente(@RequestParam("x1") Double x1,
			@RequestParam("x2") Double x2, @RequestParam("y1") Double y1, @RequestParam("y2") Double y2) {
		String nombreMetodo = new Object() {
		}.getClass().getEnclosingMethod().getName();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
		Response res = new Response();
		logger.info("Ejecucion " + nombreMetodo + "[ parametro1: " + x1 + ", parametro2: " + x2 + ", parametro3:" + y1 + ", parametro4; " + y2 + "] ");
		try {
			if (ValidadorCampos.validarCamposPendiente(x1, x2, y1, y2)) {
				res = operacionesService.calcularPendiente(x1, x2, y1, y2);
			} else {
				res.setCodigo(HttpStatus.BAD_REQUEST.value());
				res.setMensaje("Los numeros no deben estar vacios.");
			}
		} catch (Exception e) {
			logger.error("Error ejecutando " + nombreMetodo, e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		String salida = gson.toJson(res);
		logger.info("Respuesta metodo: " + nombreMetodo + ": " + salida);
		return new ResponseEntity<>(salida, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Metodo que calcula el promedio d euin alista de nuemros
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	@RequestMapping(value = "/average", method = RequestMethod.POST)
	public ResponseEntity<String> pendiente(@RequestBody String json) {
		String nombreMetodo = new Object() {
		}.getClass().getEnclosingMethod().getName();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
		Response res = new Response();
		PromedioRequest request = new PromedioRequest();
		logger.info("Ejecucion " + nombreMetodo + "[ json entrada: " + json + "] ");
		try {
			request = gson.fromJson(json, PromedioRequest.class);
			if (ValidadorCampos.validarLista(request.getNumeros())) {
				res = operacionesService.calcularPromedio(request.getNumeros());
			} else {
				res.setCodigo(HttpStatus.BAD_REQUEST.value());
				res.setMensaje("La lista de numeros no debe estar vacia.");
			}
		} catch (Exception e) {
			logger.error("Error ejecutando " + nombreMetodo, e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		String salida = gson.toJson(res);
		logger.info("Respuesta metodo: " + nombreMetodo + ": " + salida);
		return new ResponseEntity<>(salida, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Metodo que calcula el area de un triangulo
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	@RequestMapping(value = "/triangle_area", method = RequestMethod.GET)
	public ResponseEntity<String> area(@RequestParam("base") Double base,
			@RequestParam("height") Double heigth) {
		String nombreMetodo = new Object() {
		}.getClass().getEnclosingMethod().getName();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
		Response res = new Response();
		logger.info("Ejecucion " + nombreMetodo + "[ parametro1: " + base + ", parametro2: " + heigth + "] ");
		try {
			if (ValidadorCampos.validarCampos(base, heigth)) {
				res = operacionesService.calcularAreaTriangulo(base, heigth);
			} else {
				res.setCodigo(HttpStatus.BAD_REQUEST.value());
				res.setMensaje("La base y la altura no deben estar vacias");
			}
		} catch (Exception e) {
			logger.error("Error ejecutando " + nombreMetodo, e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		String salida = gson.toJson(res);
		logger.info("Respuesta metodo: " + nombreMetodo + ": " + salida);
		return new ResponseEntity<>(salida, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Metodo que calcula el area de un triangulo
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	@RequestMapping(value = "/circle_area", method = RequestMethod.GET)
	public ResponseEntity<String> area(@RequestParam("radio") Double radio) {
		String nombreMetodo = new Object() {
		}.getClass().getEnclosingMethod().getName();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
		Response res = new Response();
		logger.info("Ejecucion " + nombreMetodo + "[ parametro1: " + radio + "] ");
		try {
			if (radio != null) {
				res = operacionesService.calcularAreaCirculo(radio);
			} else {
				res.setCodigo(HttpStatus.BAD_REQUEST.value());
				res.setMensaje("El radio no debe estar vacio");
			}
		} catch (Exception e) {
			logger.error("Error ejecutando " + nombreMetodo, e);
			res.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMensaje(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		String salida = gson.toJson(res);
		logger.info("Respuesta metodo: " + nombreMetodo + ": " + salida);
		return new ResponseEntity<>(salida, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
