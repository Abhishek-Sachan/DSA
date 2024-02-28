package hashmap;

import java.util.HashMap;

public class ItineraryFromTickets {

	// find ITINERARY from tickets
	
	public static String getStart(HashMap<String, String> ticketMap) {
		HashMap<String, String> reverseMap= new HashMap<>();
		
	for(String key:ticketMap.keySet()) {
		
		///   key= ticketMap.get(key), value=key
		reverseMap.put(ticketMap.get(key), key);
	}
	
for(String key:ticketMap.keySet()) {
	if(!reverseMap.containsKey(key)) {
		return key;
	}
}
return null;
	}
	public static void main(String[] args) {
		HashMap<String, String> ticketMap= new HashMap<>();
		ticketMap.put("chennai", "bengaluru");
		ticketMap.put("mumbai", "delhi");
		ticketMap.put("goa", "chennai");
		ticketMap.put("delhi", "goa");
		
		String start= getStart(ticketMap);
		while(ticketMap.containsKey(start)) {
			System.out.print(start+" ->");
			start=ticketMap.get(start);
		}
		System.out.println(start);
	}

}
