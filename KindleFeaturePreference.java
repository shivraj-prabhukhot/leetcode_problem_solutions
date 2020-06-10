import java.util.*;
//Kindle top most user preferred feature selection
public class Application {

	public static ArrayList<String> popularNFeatures(int numFeatures,
	                                                 int topFeatures,
	                                                 List<String> possibleFeatures,
	                                                 int numFeatureRequests,
	                                                 List<String> featureRequests) {
		ArrayList<String> result = new ArrayList();
		HashMap<String, Integer> map = new HashMap();
		HashSet<String> setCompetitors = new HashSet<String>(possibleFeatures);

		for(String review: featureRequests) {
			for(String competitor: setCompetitors) {
				if(review.toLowerCase().contains(competitor.toLowerCase())) {
					if(map.containsKey(competitor)) {
						map.put(competitor, (map.get(competitor) + 1));
					} else {
						map.put(competitor, 1);
					}
				}
			}
		}

		System.out.println(map);

		map = sortByValue(map);

		System.out.println(map);

		int count = 0;
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			result.add(e.getKey());
			count++;
			if(count == topFeatures) {
				break;
			}
		}

		return result;
	}

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
	{
		List<Map.Entry<String, Integer> > list =
				new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
			public int compare(Map.Entry<String, Integer> o1,
			                   Map.Entry<String, Integer> o2)
			{
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static void main(String[] args) {
		List<String> possibleFeatures = new ArrayList<String>();
		possibleFeatures.add("storage");
		possibleFeatures.add("battery");
		possibleFeatures.add("nightVision");

		List<String> featureRequests = new ArrayList<String>();
		featureRequests.add("Pretty good storage space is required.");
		featureRequests.add("Pretty good battery life is required.");
		featureRequests.add("Pretty good nightVision and battery is required.");
		System.out.println(Application.popularNFeatures(4,2,possibleFeatures,3,featureRequests));
	}
}
