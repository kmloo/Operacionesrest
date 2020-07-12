package co.com.ws.entity;

import com.google.gson.annotations.SerializedName;

public class Response {

	@SerializedName("respuesta")
	private Double respuesta;

	@SerializedName("mensaje")
	private String mensaje;

	@SerializedName("codigo")
	private Integer codigo;

	public Double getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Double respuesta) {
		this.respuesta = respuesta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
