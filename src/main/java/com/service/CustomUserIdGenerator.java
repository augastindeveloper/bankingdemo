package com.service;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomUserIdGenerator implements IdentifierGenerator{
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Random random = new Random();

		return Long.parseLong(randomDigits(random, 6));
	}

	public static String randomDigits(Random random, int length) {
		char[] a = new char[length];
		a[0] = (char) ('1' + random.nextInt(9));

		for (int i = 1; i < length; i++) {
			a[i] = (char) ('0' + random.nextInt(10));
		}
		return new String(a);

	}

}
