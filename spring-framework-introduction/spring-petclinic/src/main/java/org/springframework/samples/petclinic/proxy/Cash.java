package org.springframework.samples.petclinic.proxy;

public class Cash implements Payment {
	public void pay(int amount) {
		System.out.println(amount + " 현금 결제");
	}
}
