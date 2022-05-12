package com.Grupo10OO22022;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCryptPasswordEncoder {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		System.out.println("\n admin -->" + pe.encode("admin") + "\n");
		
		System.out.println("\n auditor -->" + pe.encode("auditor")  + "\n");
	}
}
