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
		
		int gamma = gammaRate(input);
		
		
		System.out.println(((Math.pow(2, input[0].length())-1)*gamma) - (gamma*gamma));
		
	}

	private static int gammaRate(String[] input) {
		int[] gammaDigits = new int[input[0].length()];

		for(int i = 0; i < gammaDigits.length; i++) {
			int ones = 0;
			for(String inp: input) if(inp.charAt(i) == '1') ones++;
			if(ones > (input.length - ones)) gammaDigits[i] = 1;
			else gammaDigits[i] = 0;
		}
		
		String gammaBin = "";
		
		for(int digit: gammaDigits) gammaBin += digit;
		
		int gamma = Integer.parseInt(gammaBin, 2);
		
		return gamma;
		
	}
	
}
