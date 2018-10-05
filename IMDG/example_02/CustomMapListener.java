import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.MapEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryEvictedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.EntryUpdatedListener;
import com.hazelcast.map.listener.MapClearedListener;
import com.hazelcast.map.listener.MapEvictedListener;

public class CustomMapListener implements EntryAddedListener<Integer, String>,
										  EntryRemovedListener<Integer, String>,
										  EntryUpdatedListener<Integer, String>,
										  EntryEvictedListener<Integer, String>,
										  MapEvictedListener,
										  MapClearedListener {

	@Override
	public void mapCleared(MapEvent event) {
		System.out.println("Map Cleared: "+ event.getName());
		
	}

	@Override
	public void mapEvicted(MapEvent event) {
		
		System.out.println("Map Evicted: "+ event.getName());		
	}

	@Override
	public void entryEvicted(EntryEvent<Integer, String> event) {
		String output = String.format("An Entry with key = %d and value = %s Evicted ", event.getKey(), event.getValue());
		System.out.println(output);		
	}

	@Override
	public void entryUpdated(EntryEvent<Integer, String> event) {
		String output = String.format("An Entry with key = %d and value = %s Updated with new value = %s ",event.getKey(),	event.getOldValue(), event.getValue());
		System.out.println(output);		
		
	}

	@Override
	public void entryRemoved(EntryEvent<Integer, String> event) {
		String output = String.format("An Entry with key = %d and value = %s Removed ", event.getKey(), event.getValue());
		System.out.println(output);		
		
	}

	@Override
	public void entryAdded(EntryEvent<Integer, String> event) {
		String output = String.format("An Entry with key = %d and value = %s Added ", event.getKey(), event.getValue());
		System.out.println(output);		
		
	}
	

}
