package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		String[] input = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/input.txt")))) {
			input = reader.lines().toArray(String[]::new);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println(countDepthIncreases(input));
		System.out.println(countSlidingWindowIncreases(input, 3));
	}
	
	private static int countDepthIncreases(String[] depths) {
		
		int increases = 0;
		
		for(int i = 1; i < depths.length; i++) if(Integer.parseInt(depths[i]) > Integer.parseInt(depths[i-1])) increases++;
		
		return increases;
	}
	
	private static int countSlidingWindowIncreases(String[] depths, int windowSize) {
		
		int increases = 0;
		
		for(int i = windowSize + 1; i <= depths.length; i++) {
			int window1 = getWindowSum(i - windowSize - 1, i - 2, depths),
			window2 = getWindowSum(i - windowSize, i - 1, depths);
			
			if(window2 > window1) increases++;
		}
		
		return increases;
	}
	
	private static int getWindowSum(int start, int end, String[] input) {
		int res = 0;
		for(int i = start; i <= end; i++) {
			res += Integer.parseInt(input[i]);
			System.out.print(input[i] + ", ");
		}
		System.out.println();
		return res;
	}
	
}
