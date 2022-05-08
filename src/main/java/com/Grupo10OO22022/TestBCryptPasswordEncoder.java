package com.Grupo10OO22022;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCryptPasswordEncoder {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		System.out.println(pe.encode("admin"));
		System.out.println(pe.encode("auditor"));
	}
}
