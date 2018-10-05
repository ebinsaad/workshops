import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HCListen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Config config = new Config();
		HazelcastInstance hazelcast = Hazelcast.newHazelcastInstance(config);
		
		String mapName = "customers";
		
		IMap<Integer, String> myMap = hazelcast.getMap(mapName);
		
		myMap.addEntryListener(new CustomMapListener(),true);
		
		System.out.println("Entry Listener have been registred for "+ mapName);
		
				
		
	}

}
