package com.resonance.commons.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CorsFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, PATCH, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", 
				"accept-language, User-Language, Content-Type, username, x-requested-with,User-Id,x-csc-User-Id,iPlanetDirectoryPro,X-IBM-Client-Id,X-IBM-Client-Secret");

		response.addHeader("Access-Control-Allow-Credentials", "true");


		if ((!request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) || (
				(request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) && 
				(request.getHeader("Access-Control-Request-Headers") == null))) {
			filterChain.doFilter(request, response);
			}
	}
}