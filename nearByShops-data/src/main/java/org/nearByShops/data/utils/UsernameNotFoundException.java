package org.nearByShops.data.utils;

public class UsernameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsernameNotFoundException(String message, Throwable err) {
		super(message, err);
	}

	public UsernameNotFoundException(String message) {
		super(message);
	}
}
