package com.sampleGenerator;
import java.util.Random;


public class generator {
	
	public static double tick_size=0.05;
	public static double ltp;
	public static int last_vol=1000;
	
	
	
	public static int generateVol(double ltp, double price) {
		int vol = last_vol;
		
		Random rnd_vol = new Random();
		
		if (price>ltp) {
			vol = (int)Math.round(rnd_vol.nextGaussian()*100 +(last_vol+200*Math.abs(ltp-price)));
		}
		else if (ltp>price) {
			vol = (int)Math.round(rnd_vol.nextGaussian()*100 +(last_vol+200*Math.abs(ltp-price)));
		}
			else {
			vol = (int)Math.round(rnd_vol.nextGaussian()*100 +last_vol);
			}
		
		return vol;
	}
	
	
	public static double generatePrice() {
		

		Random rnd_price = new Random();
		double price = (double) Math.round((rnd_price.nextGaussian() * 2 + 155) * 100) / 100;
		price= (double)Math.round((Math.round(price/tick_size )*tick_size)*100)/100;
		
		return price;
		
		
	}
	
	
	public static boolean generateBuySell() {
		

		Random buy_sell =new Random();

		boolean buy = buy_sell.nextBoolean();
		
		return buy;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		generator gen = new generator();
		
//		
//		double ltp=155;
//		int vol=1000;
		for (int i=0;i<20;i++) {
			
			double price = gen.generatePrice();
			
			int vol = gen.generateVol(ltp,price);
			
			boolean buy = gen.generateBuySell();
				
			if (buy) {
				System.out.println("Buy order placed for FB at: "+price+" for quantity: "+vol);
			}
			else {
				System.out.println("Sell order placed for FB at: "+price+" for quantity: "+vol);

			}
			
			ltp=price;
			try {
			    Thread.sleep(1000);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		}
	}

}
