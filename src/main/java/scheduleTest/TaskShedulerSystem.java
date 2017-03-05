package scheduleTest;

/**
 * 调度的主线程
 * 
 * @author yexx
 * @vesion 1.0
 */
public class TaskShedulerSystem {
	public static void main(String[] args) throws Exception {

		// 启动一个生产者线程，模拟任务的产生
		new Thread(new TaskProducer(), "A").start();
		new Thread(new TaskProducer(), "B").start();

		Thread.sleep(3000);

		// 启动一个线程者线程，模拟任务的处理
		new Thread(new TaskConsumer()).start();

		// 主线程休眠
		// Thread.sleep(30000);
	}
}
