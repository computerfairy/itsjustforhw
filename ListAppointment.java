import java.sql.SQLException;
import java.util.Scanner;

public class ListAppointment {
	private Scanner userInput = new Scanner(System.in);
	private AppointmentDAO dbAction = new AppointmentDAO();
	private int selectedAppointmentMenu = 0;
	private int selectedAppointment = 0;

	public void listAppointment() throws Exception {		
		while(selectedAppointmentMenu != 4) {
			dbAction.SelectAppointment("listAll", 0);
			System.out.println();
			
			System.out.println("--------약속 관리--------");
			System.out.println("1. 약속 등록");
			System.out.println("2. 약속 수정");
			System.out.println("3. 약속 삭제");
			System.out.println("4. 메인 메뉴로 돌아가기");
			System.out.println("---------------------");
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
	
	private void checkAppointmentMenu(){
		if(selectedAppointmentMenu < 1 || selectedAppointmentMenu > 4) {
			System.out.println("다시 입력해주세요.");
			System.out.println();
		}
		
		if(selectedAppointmentMenu == 1) {
			try {
				dbAction.CreateAppointment();
				System.out.println();
			} catch (SQLException ex) {
				System.out.println("에러가 발생했습니다. 다시 시도해주세요");
				System.err.println(ex);
			}
		}
		
		if(selectedAppointmentMenu == 2) {
			try {
				System.out.print("수정할 약속의 번호를 입력해주세요: ");
				selectedAppointment = userInput.nextInt();
				String aid = dbAction.SelectAppointment("getAid", selectedAppointment);
				dbAction.ModifyAppointment(aid);
				System.out.println();
			} catch (SQLException ex) {
				System.out.println("에러가 발생했습니다. 다시 시도해주세요");
				System.err.println(ex);
			}
		} 
		
		if(selectedAppointmentMenu == 3){
			try { 
				System.out.print("삭제할 약속의 번호를 입력해주세요: ");
				selectedAppointment = userInput.nextInt();
				String aid = dbAction.SelectAppointment("getAid", selectedAppointment);
				dbAction.DeleteAppointment(aid);
				System.out.println();
			} catch (SQLException ex) {
				System.out.println("에러가 발생했습니다. 다시 시도해주세요");
				System.err.println(ex);
			}
		}
	}	
}
