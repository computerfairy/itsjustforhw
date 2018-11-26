import java.util.Date;
import java.util.Scanner;

public class ListAppointment {
	
	Scanner userInput = new Scanner(System.in);
	AppointmentDAO dbAction = new AppointmentDAO();
	Date date;
	
	private int selectedAppointmentMenu = 0;

	public void listAppointment() {
		
		dbAction.SelectAppointment("listAll", date,"");
		System.out.println();
		
		while(selectedAppointmentMenu != 4) {
			
			System.out.println("--------약속 관리--------");
			System.out.println("1. 약속 등록");
			System.out.println("2. 약속 수정");
			System.out.println("3. 약속 삭제");
			System.out.println("4. 메인 메뉴로 돌아가기");
			System.out.print("원하는 메뉴를 입력하세요 : ");
			
			try { 
				selectedAppointmentMenu = userInput.nextInt();
				System.out.println();
			} catch (Exception e) {
				System.out.println();
				System.out.println("숫자로  다시 입력해주세요.");
				System.out.print("원하는 메뉴를 입력하세요: ");
				userInput = new Scanner(System.in);
				selectedAppointmentMenu = userInput.nextInt();
			}
			
			checkAppointmentMenu();
			
		}
		
	}
	
	private void checkAppointmentMenu() {
		
		if(selectedAppointmentMenu < 1 || selectedAppointmentMenu > 4) {
			System.out.println("다시 입력해주세요.");
			System.out.println();
		}
		
		if(selectedAppointmentMenu == 1) {
			dbAction.CreateAppointment();
			System.out.println();
		}
		
		if(selectedAppointmentMenu == 2) {
			dbAction.ModifyAppointment(0); //int aid 필요
			System.out.println();
		} 
		
		if(selectedAppointmentMenu == 3){
			dbAction.DeleteAppointment(0); //int aid 필요
			System.out.println();
		}
		
	}
	
}
