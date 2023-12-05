package view;

import java.util.Scanner;

import models.People;

public class ConsoleView {
	
	public Integer getDeservedOperation() {
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("\nDeserved operation: \n" + "[1] - Save people \n" + "[2] - Remove people \n"
					+ "[3] - Search People \n" + "> ");
			Integer userChoice = scanner.nextInt();
			
			scanner.close();
			
			return userChoice;
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
			return null;
		}
	}
	
	public People getPeopleObject() {
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("People name: ");
			String name = scanner.nextLine();
			System.out.print("People email: ");
			String email = scanner.nextLine();
			
			People people = new People(null, name, email);
			
			scanner.close();
			
			return people;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public Integer getPeopleId() {
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("People ID: ");
			Integer id = scanner.nextInt();
			
			scanner.close();
			
			return id;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
