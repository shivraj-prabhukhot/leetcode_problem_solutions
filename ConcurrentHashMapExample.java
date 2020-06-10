import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentHashMapExample {

	static Map<String, AtomicLong> orders = new ConcurrentHashMap<>();

	static void processOrders(){
		for(String city : orders.keySet()){
			for(int i = 0; i <50; i++) {
				orders.get(city).getAndIncrement();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		orders.put("Pune", new AtomicLong());
		orders.put("Mumbai", new AtomicLong());
		orders.put("Delhi", new AtomicLong());
		orders.put("Nagpur", new AtomicLong());

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(ConcurrentHashMapExample :: processOrders);
		service.submit(ConcurrentHashMapExample :: processOrders);

		service.awaitTermination(1, TimeUnit.SECONDS);
		service.shutdown();

		System.out.println(orders);
	}

}

class Order{
	String city;
	AtomicLong order;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public AtomicLong getOrder() {
		return order;
	}

	public void setOrder(AtomicLong order) {
		this.order = order;
	}
}