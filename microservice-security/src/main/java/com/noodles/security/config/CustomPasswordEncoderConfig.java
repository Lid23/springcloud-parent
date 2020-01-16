package com.noodles.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @filename CustomPasswordEncoderConfig
 * @description 统一身份认证-设置Encoder
 * @autor Eric
 * @date 2019/7/25 16:15
 */
public class CustomPasswordEncoderConfig implements PasswordEncoder {
	@Override
	public String encode(CharSequence charSequence) {
		return charSequence.toString();
	}

	@Override
	public boolean matches(CharSequence charSequence, String s) {
		return s.equals(charSequence.toString());
	}
}
