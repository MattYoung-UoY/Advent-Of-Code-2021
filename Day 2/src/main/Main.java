package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	private static int horiz = 0, depth = 0, aim = 0;

	public static void main(String[] args) {

		String[] input = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/input.txt")))) {
			input = reader.lines().toArray(String[]::new);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		for (String command : input)
			execute(command.split(" ")[0], Integer.parseInt(command.split(" ")[1]));

		System.out.println(horiz + ", " + depth);
		
		horiz = 0;
		depth = 0;
		
		for (String command : input)
			executeAim(command.split(" ")[0], Integer.parseInt(command.split(" ")[1]));

		System.out.println(horiz + ", " + depth);
		
	}

	private static void execute(String command, int param) {
		switch (command) {
		case "forward":
			horiz += param;
			break;
		case "down":
			depth += param;
			break;
		case "up":
			depth -= param;
			break;
		}
	}

	private static void executeAim(String command, int param) {
		switch (command) {
		case "forward":
			horiz += param;
			depth += param * aim;
			break;
		case "down":
			aim += param;
			break;
		case "up":
			aim -= param;
			break;
		}
	}
	
}
