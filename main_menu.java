import java.util.Scanner;

public class main_menu {
	public static void main(String[] args) {	
		Scanner userInput = new Scanner(System.in);
		int selectedMenu = 0;
		
		while(selectedMenu != 4) {
			System.out.println("##Personal Information Management##");
			System.out.println("==============================");
			System.out.println("1. Contacts");
			System.out.println("2. To-do lists");
			System.out.println("3. Appointments");
			System.out.println("4. 종료");
			System.out.println("==============================");
			System.out.print("원하는 메뉴를 입력하세요: ");
			
			try { 
				selectedMenu = userInput.nextInt();
				System.out.println();
			} catch (Exception e) {
				System.out.println();
				System.out.println("숫자로  다시 입력해주세요.");
				System.out.print("원하는 메뉴를 입력하세요 : ");
				userInput = new Scanner(System.in);
				selectedMenu = userInput.nextInt();
			}
			
			if(selectedMenu < 1 || selectedMenu > 4) {
				System.out.println("다시 입력해주세요.");
				System.out.println();
			}
			
			if(selectedMenu == 1) {
				
			}
			
			if(selectedMenu == 2) { 
				Todo TODOListMenu = new Todo();
				TODOListMenu.startProgram();
			} 
			
			if(selectedMenu == 3){
				ListAppointment AppointmentListMenu = new ListAppointment();
				try {
					AppointmentListMenu.listAppointment();
				} catch (Exception ex) {
					System.err.println("Exception: " + ex.getMessage());
				}
			}
		}
	}
}
