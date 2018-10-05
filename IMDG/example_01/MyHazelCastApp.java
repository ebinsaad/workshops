

import java.util.Map;
import java.util.Queue;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class MyHazelCastApp {

	public static void main(String[] args) {
		
		
		Config config = new Config();
		HazelcastInstance hazelcast = Hazelcast.newHazelcastInstance(config);
		
		
		Map<Integer, String> myMap = hazelcast.getMap("customers");
		
		myMap.put(3, "Alex");
		myMap.put(2, "Alice");
		myMap.put(7, "Zack");
		
		System.out.println("Customer with key 2: "+ myMap.get(3));
		System.out.println("The current map size is: "+myMap.size());
		
				
        Queue<String> queueCustomers = hazelcast.getQueue("customers");
        queueCustomers.offer("Tom");
        queueCustomers.offer("Mary");
        queueCustomers.offer("Jane");
        System.out.println("First customer: " + queueCustomers.poll());
        System.out.println("Second customer: "+ queueCustomers.peek());
        System.out.println("Queue size: " + queueCustomers.size());

	}

}
