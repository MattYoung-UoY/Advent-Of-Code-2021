package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		String[] inputSrc = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/input.txt")))) {
			inputSrc = reader.lines().toArray(String[]::new);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		String[] calls = inputSrc[0].split(",");
		
		ArrayList<Board> boards = new ArrayList<Board>();
		
		for(int i = 2; i < inputSrc.length; i++) {
			String[][] board = new String[5][5];
			
		}
		
	}
	
}
