import java.util.*;
public class Sol {

	private static class IntervalComparator implements Comparator<int[]>{
		public int compare(int[] a, int[] b){
			return (a[0]< b[0] ? -1 : a[0] == b[0] ? 0 : 1);
		}
	}
	public static void main(String[] args) {
		//doHashMapSorting();
		//int[][] intervals = new int[][]{{1,4},{0,4}};
		//mergeIntervals(intervals);
		Object abc = "shivraj";


		PriorityQueue<List<String>> pq = new PriorityQueue<>(
				(a,b)->{
					if(a.get(1).equals(b.get(1)))
						return a.get(0).compareTo(b.get(0));
					else
						return a.get(1).compareTo(b.get(1));
				}
		);
	}

	public static void mergeIntervals(int[][] intervals){
		for(int i = 0; i < intervals.length; i++)
			System.out.println("{"+ intervals[i][0] + "," + intervals[i][1] + "}");

		Collections.sort(Arrays.asList(intervals), new IntervalComparator());

		LinkedList<int[]> merged = new LinkedList<int[]>();

		for(int i = 0; i< intervals.length; i++){

			if(merged.isEmpty() || merged.getLast()[1] < intervals[i][0])
				merged.add(intervals[i]);
			else
				merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
		}

		int[][]  mergedIntervals = merged.toArray(new int[merged.size()][2]);
		System.out.println("After merging:-\n");
		for(int i = 0; i < mergedIntervals.length; i++)
				System.out.println("{"+ mergedIntervals[i][0] + "," + mergedIntervals[i][1] + "}");
	}
	public static void doHashMapSorting(){
		HashMap<Integer, String> hmap = new HashMap<Integer,String>(){
			{
				put(2, "abc");
				put(23, "xyz");
				put(10,"abz");
				put(5,"qaa");
				put(0,"qwww");
				put(1,"kal");
			}
		};

		Set entrySetM = hmap.entrySet();
		Iterator itr = entrySetM.iterator();

		while(itr.hasNext()){
			Map.Entry me = (Map.Entry)itr.next();
			System.out.println(me.getKey() + " : "+ me.getValue());
		}

		System.out.println("After sorting by keySet");

		Map<Integer, String> tMap = new TreeMap<Integer, String>(hmap);
		Set eSet1 = tMap.entrySet();
		Iterator itr1 = eSet1.iterator();
		while(itr1.hasNext()){
			Map.Entry me1 = (Map.Entry) itr1.next();
			System.out.println(me1.getKey() +":"+ me1.getValue());
		}

		System.out.println("Sort by values:--->");

		Map<Integer, String> sortedMap = sortByValues(hmap);

		Set eSet = sortedMap.entrySet();
		Iterator itr2 = eSet.iterator();
		while(itr2.hasNext()){
			Map.Entry me = (Map.Entry) itr2.next();
			System.out.println(me.getKey() +":"+ me.getValue());
		}
	}
	public static Map<Integer, String> sortByValues(Map<Integer, String> hmap){
		List linkedList = new LinkedList(hmap.entrySet());

		Collections.sort(linkedList, new Comparator(){
			public int compare(Object obj1, Object obj2){
				return (((Comparable)((Map.Entry)(obj1)).getValue()).compareTo(((Map.Entry)obj2).getValue()));
			}
		});

		Map<Integer, String> linkedHMap = new LinkedHashMap<Integer,String>();
		for(Iterator itr=linkedList.iterator(); itr.hasNext();){
			Map.Entry me = (Map.Entry)itr.next();
			linkedHMap.put((Integer)me.getKey(), (String)me.getValue());
		}
		return linkedHMap;
	}





}