package co.com.wsco.com.ws.util;

import java.util.ArrayList;
import java.util.List;

public class ValidadorCampos {

	public static Boolean validarCampos(Double uno, Double dos) {
		if (uno == null || dos == null) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public static Boolean validarCamposDivision(Double uno, Double dos) {
		if (uno == null || dos == null) {
			return Boolean.FALSE;
		} else if (dos != null && dos == 0) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public static Boolean validarCamposPendiente(Double uno, Double dos, Double tres, Double cuatro) {
		if (uno == null || dos == null || tres == null || cuatro == null) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public static Boolean validarLista(List<Double> numeros) {
		if (numeros == null || numeros.isEmpty()) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public static List<Double> procesarLista(List<Double> numeros) {
		List<Double> restorno = new ArrayList<>();
		for (Double n : numeros) {
			if (n != 0) {
				restorno.add(n);
			}
		}
		return restorno;
	}
}
