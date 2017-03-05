package scheduleTest;

import java.util.Random;
import java.util.UUID;

import redis.clients.jedis.Jedis;

/**
 * 模拟一个生产者
 * 
 * @author yexx
 * @vesion 1.0
 */
public class TaskProducer implements Runnable {

	Jedis jedis = new Jedis("120.25.12.92", 6379);

	public void run() {
		Random random = new Random();
		while (true) {
			if (jedis.llen("task-queue") >= 5) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(random.nextInt(600) + 600);
					// 模拟生成一个任务
					UUID taskid = UUID.randomUUID();
					// 将任务插入任务队列：task-queue
					jedis.lpush("task-queue", taskid.toString());
					System.out.println(Thread.currentThread().getName() + "插入了一个新的任务： " + taskid);
					System.out.println("----" + jedis.llen("task-queue") + "----");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}