package com.surittec.desafio.services.auth;

import com.surittec.desafio.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserSService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
