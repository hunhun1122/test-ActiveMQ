package com.xaq.test;

/**
 * 生产者测试
 * @author xaq
 *         <p>
 * 		Description
 *         </p>
 * @date 2018年4月26日
 */
public class TestProducter {
	public static void main(String[] args) {
		Producter producter = new Producter();
		producter.init();
		TestProducter testMq = new TestProducter();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // Thread 1
		new Thread(testMq.new ProductorMq(producter)).start(); // Thread 2
		new Thread(testMq.new ProductorMq(producter)).start(); // Thread 3
		new Thread(testMq.new ProductorMq(producter)).start(); // Thread 4
		new Thread(testMq.new ProductorMq(producter)).start(); // Thread 5
		new Thread(testMq.new ProductorMq(producter)).start();
	}

	private class ProductorMq implements Runnable {
		Producter producter;

		public ProductorMq(Producter producter) {
			this.producter = producter;
		}

		@Override
		public void run() {
			while (true) {
				try {
					producter.sendMessage("Jaycekon-MQ");
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}