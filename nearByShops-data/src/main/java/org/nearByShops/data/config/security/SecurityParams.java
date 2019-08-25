package org.nearByShops.data.config.security;

public class SecurityParams {
	public static final String JWT_HEADER_NAME = "Authorization";
	public static final String SECRET = "careers.com";
	public static final long EXPIRATION = 10 * 24 * 3600;
	public static final String HEADER_PREFIX = "Bearer ";

	private SecurityParams() {
	}
}
