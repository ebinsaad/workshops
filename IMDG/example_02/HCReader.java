import java.util.Map;
import java.util.Scanner;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HCReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Config config = new Config();
		HazelcastInstance hazelcast = Hazelcast.newHazelcastInstance(config);
		IMap<Integer, String> myMap = hazelcast.getMap("customers");
		
		int c = -1;
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("please select one of the following options");
			System.out.println("press 1 to add new customer to the system");
			System.out.println("press 2 to remove a customer from the system");
			System.out.println("press 3 to update a customer in the system");
			System.out.println("press 4 to delete all customers in the system");
			System.out.println("press 5 to display the total number of customers in the system");
			c = sc.nextInt();
			
			int key;
			String value;
			
			switch(c) {
			case 1:
				System.out.println("please enter the customer ID");
				key = sc.nextInt();
				sc.nextLine();
				System.out.println("please enter the customer name");
				value = sc.nextLine();
				myMap.put(key, value);
				break;
			case 2:
				System.out.println("please enter the customer ID");
				key = sc.nextInt();
				sc.nextLine();
				value = myMap.get(key);
				System.out.println("removes =  "+ value);
				break;
			case 3:
				System.out.println("please enter the customer ID");
				key = sc.nextInt();
				sc.nextLine();
				System.out.println("please enter the customer name");
				value = sc.nextLine();
				myMap.replace(key, value);
				break;
			case 4:
				myMap.clear();
				break;
			case 5:
				System.out.println("current number of customers is: "+myMap.size());
				break;
			default:
				c = -1;	
			}			
			
			System.out.println("");
		}while(c!=-1);

	}

}
