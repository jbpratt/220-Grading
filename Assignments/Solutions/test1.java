import java.util.Scanner;

public class Main{
	
	public static void main(String[] args){
	
		menu();
	
	}
	
	//the app should provide a user menu with 3 options: convert currencies, restaurant POS, exit
	//the menu should do error checking and inform the user if they did not make a valid selection
    //then show the menu again
    
	public static final String MENU_CONSTANT_1 = "Press 1 to Convert, Press 2 to Go to POS, Press 3 to Exit";
	public static final String EXIT_MESSAGE = "Bye Bye!";

	public static void menu(){
	
			Scanner scanner = new Scanner(System.in);
			
			System.out.println(MENU_CONSTANT);
	
			String userInput = "";

			userInput = scanner.nextLine();

			while(!userInput.equals("1") || !userInput.equals("2")){
				System.out.println(EXIT_MESSAGE);
				
				System.exit(0);
			}

			



	
	}
	
}