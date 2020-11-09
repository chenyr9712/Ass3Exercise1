import java.util.ArrayList;
import java.util.List;

public class MyFilterTest {
	public static String[] filter(String[] a, Filter<String> f) {
		List<String> filters = new ArrayList<String>();
		for (String s : a) {
			if (f.accept(s)) {
				filters.add(s);
			}
		}
		String[] strs = new String[filters.size()];
		filters.toArray(strs);
		return strs;
	}

	public static int[] filter(int[] a, Filter<Integer> f) {
		List<Integer> filters = new ArrayList<Integer>();
		for (int s : a) {
			if (f.accept(s)) {
				filters.add(s);
			}
		}
		Integer[] ints = new Integer[filters.size()];
		filters.toArray(ints);
		int[] result = new int[ints.length];
		for (int i = 0; i < ints.length; i++) {
			result[i] = ints[i];
		}
		return result;
	}

	public static void main(String[] args) {
		String[] strs = new String[] { "ushdndhs", "sdasddsfdsa", "asfdjsdkfhjdsf", "asdsad" };
		System.out.print("Original£º");
		print(strs);
		/*
		 * filter an array of strings and accepting all strings that contain at least
		 * nine characters and store it in array called longStrings.
		 */
		String[] longStrings = filter(strs, new Filter<String>() {
			@Override
			public boolean accept(String x) {
				return x.length() >= 9;
			}
		});
		System.out.print("longStrings£º");
		print(longStrings);
		
		int[] ints = new int[] { 1, 2, -2, 0, 43, 2, -12 };
		System.out.print("Original£º");
		print(ints);
		/*
		 * filter an array of numbers and accepting all non negative numbers, store the
		 * result in array called positiveNumbers
		 */
		int[] positiveNumbers = filter(ints, new Filter<Integer>() {
			@Override
			public boolean accept(Integer x) {
				return x < 0;
			}
		});
		System.out.print("positiveNumbers£º");
		print(positiveNumbers);
	}
	
	private static <T> void print(T[] tArray)
	{
		for(T t2 :tArray)
		{
			System.out.print(t2.toString()+"  ");
		}
		System.out.println();
	}
	
	private static    void print(int[] tArray)
	{
		for(int t2 :tArray)
		{
			System.out.print(t2 +"  ");
		}
		System.out.println();
	}
}
