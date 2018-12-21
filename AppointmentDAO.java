import java.sql.*;
import java.util.Scanner;

public class AppointmentDAO {
	private Scanner userInput1 = new Scanner(System.in);
	private Scanner userInput2 = new Scanner(System.in);
	protected int dataNum = 0;
	
	//JDBC driver name and Database url
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	
	//Database credentials
	private static final String user = "javadb";
	private static final String passwd = "1234";
	protected static Connection conn = null;
	protected static Statement stmt = null;
	private String mySQL = null;
	private ResultSet rs = null;
	
	//Appointment Database columns
	protected String a_id = "";
	private String a_content = "";
	private String a_date = "";
	private String a_location = "";
	private String a_persons = "";
	
	protected void DBConnect() {	
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, passwd);
			stmt = conn.createStatement();
		} catch (Exception ex) {
			System.err.println("DBConnect Exception: " + ex.getMessage());
		}
	}
	
	private void DBClose() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
			System.err.println("DBClose Exception: " + ex.getMessage());
		}
	}

	public void CreateAppointment() throws SQLException {
		System.out.println("###약속 등록 메뉴###");
		dataNum++;
		SetAppointmentFromUserInput();
		
		DBConnect();
		mySQL = "insert into myAppointments values('"+a_id+"','"+a_content+"','"+a_date+"','"+a_location+"','"+a_persons+"')";
		rs = stmt.executeQuery(mySQL);
		
		System.out.println(); 
		System.out.println("약속 등록이 완료되었습니다."); 
		DBClose();
	}
	
	public void ModifyAppointment(String aid) throws SQLException {
		System.out.println("###약속 수정 메뉴###");
		SetAppointmentFromUserInput();

		DBConnect();
		
		mySQL = "update myAppointments set aid= '"+a_id+"',acontent='"+a_content+"', adate='"+a_date+"', alocation='"+a_location+"', apersons='"+a_persons+"' where aid='"+aid+"'";
		rs = stmt.executeQuery(mySQL);
		
		System.out.println(); 
		System.out.println("약속 수정이 완료되었습니다."); 
		DBClose();
	}
	
	public void DeleteAppointment(String aid) throws SQLException {
		dataNum--;
		DBConnect();

		mySQL = "delete from myAppointments where aid='"+aid+"'";
		rs = stmt.executeQuery(mySQL);
		
		System.out.println(); 
		System.out.println("약속 삭제가 완료되었습니다."); 
		DBClose();
	}
	
	public String SelectAppointment(String searchType, int selectedAppointmentNum) throws SQLException {
		DBConnect();
		
		if(searchType.equals("listAll")) {
			System.out.println("[전체 약속 리스트]");
			System.out.println("번호  날짜                   내용                   장소                   만나는 사람");
			
			mySQL = "select * from myAppointments order by adate";
			rs = stmt.executeQuery(mySQL);
			
			dataNum = 0;
			while(rs.next()) {
				dataNum++;
				a_id = rs.getString("aid");
				a_content = rs.getString("acontent");
				a_date = rs.getString("adate").split(" ")[0];
				a_location = rs.getString("alocation");
				a_persons = rs.getString("apersons");
				System.out.print(dataNum+"  ");
				if(a_content == null) {a_content = " ";}
				if(a_location == null) {a_location = " ";}
				if(a_persons == null) {a_persons = " ";}
				System.out.println(a_date+"  "+a_content+"  "+a_location+"  "+a_persons);
			}
		} else if(searchType.equals("getAid")) { 
			mySQL = "select * from myAppointments order by adate";
			rs = stmt.executeQuery(mySQL);
			
			dataNum = 0;
			while(rs.next()) {
				dataNum++;
				if(dataNum == selectedAppointmentNum) {
					a_id = rs.getString("aid");
				}
			}
		}
		
		DBClose();
		return a_id;
	}
	
	private void SetAppointmentFromUserInput() {
		System.out.print("약속 내용: ");
		a_content = userInput2.nextLine();
		
		System.out.println("약속 날짜 ");
		System.out.print("년: ");
		String year = userInput1.next();
		
		if(year.length() != 4 && year.length() != 2) {
			System.out.println("년도는 숫자로만 입력해주세요(yyyy 혹은 yy의 형식으로).");
			System.out.print("년: ");
			year = userInput1.next();
		}
		
		System.out.print("월(1-12): ");
		String month = userInput1.next();
		
		System.out.print("일(1-31): ");
		String day = userInput1.next();
		
		a_date = year+"/"+month+"/"+day;
		if(year.length() == 2) {
			year = "20"+year;
			a_id = year+month+day+dataNum;
		} else if(year.length()== 4) {
			a_id = year+month+day+dataNum;
		}
		
		System.out.print("약속 장소: ");
		a_location = userInput2.nextLine();
		
		System.out.print("만나는 사람: ");
		a_persons = userInput2.nextLine();
	}
}
