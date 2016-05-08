package br.com.devnagui.project.util;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class Util implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(Util.class);
	
	public static String removeNotNumberCharacters(String caracteres) {
		caracteres = caracteres.replaceAll("[^0-9]", "");
		return caracteres;
	}
	
	public static boolean isStringEmptyOrNull(final String string) {
		return string != null && !"".equals(string);
	}
}