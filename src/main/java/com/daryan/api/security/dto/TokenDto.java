/**
 * 31 de jan de 2019
 */
package com.daryan.api.security.dto;

/**
 * @author Daryan Avi
 *
 */
public class TokenDto 
{
	private String token; 
	
	public TokenDto() {}
	
	public TokenDto(String token) 
	{
		this.token = token;
	}

	public String getToken() 
	{
		return token;
	}

	public void setToken(String token) 
	{
		this.token = token;
	}
}