package fl.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtil {

	private int[] cards = new int[1000];
	
	private int counter = 0;
	
	public RandomUtil() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < cards.length; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list);
		Collections.shuffle(list);
		Collections.shuffle(list);
		
		for (int i = 0; i < cards.length; i++) {
			cards[i] = list.get(i);
		}
	}
	
	public int getNext() {
		return cards[counter++ % 1000];
	}
	
	public static void main(String[] a) {
		RandomUtil r = new RandomUtil();
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum += r.getNext();
			
		}
		System.out.println(sum);
		System.out.println((999 * 1000) / 2);
	}
}
