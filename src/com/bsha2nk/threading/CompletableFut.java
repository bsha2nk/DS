package com.bsha2nk.threading;

import java.util.concurrent.CompletableFuture;

public class CompletableFut {

	public static void main(String[] args) {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(CompletableFut::getOne).thenAccept(CompletableFut::take);
//		System.out.println(cf.isDone());
	}
	
	static void take(int i) {
		System.out.println(i * 10);
	}
	
	static int getOne() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
}