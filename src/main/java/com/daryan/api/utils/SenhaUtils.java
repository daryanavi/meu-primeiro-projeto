/**
 * 27 de jan de 2019
 */
package com.daryan.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Daryan Avi
 *
 */
public class SenhaUtils
{
	public static String gerarBCrypt(String senha)
	{
		return senha == null ? senha : new BCryptPasswordEncoder().encode(senha);
	}
	
	public static boolean senhaValida(String senha, String senhaEncoded)
	{
		return new BCryptPasswordEncoder().matches(senha, senhaEncoded);
	}
}