import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Todo {
	
	private List<TodoList> todoList;
	private TodoList todo;
	private Scanner input;
	private boolean result;
	
	
	public Todo() {
		this.todoList = new ArrayList<TodoList>();
		this.input = new Scanner(System.in);
	}

	public List<TodoList> gettodoList() {
		return todoList;
	}

	public void settodoList(List<TodoList> todoList) {
		this.todoList = todoList;
	}
	
	public void startProgram(){
		
		int choice = 0;
		
		while( true ) {
			this.todo = new TodoList();
			
			System.out.println("1.TO-DO ���� / 2. TO-DO ���� / 3. TO-DO ���� / 4. TO-DO ����");
			
			try{
				choice = input.nextInt();
			}
			catch(InputMismatchException ime) {
				System.out.println("�߸��Է��߽��ϴ�.");
				startProgram();
			}
			
			if( choice == 1 ) {
				todo = new TodoList();
				System.out.println("������¥/����/���� �� ������� �Է��ϼ���.");
		
				String createdate = input.next();
				todo.setCreatedate(createdate);
				todo.setDue( input.next() );
				todo.setDescription( input.nextLine() );
				this.addNewTodo(todo);
			}
			else if ( choice == 2 ) {
				while(true){
					System.out.println("�˻��� ��¥�� �Է��ϼ���.");
					String searchCreatedate = input.next();
					if(this.result = this.gettodoByCreatedate(searchCreatedate) ){
							printInfo();
						}
						else {
							System.out.println("�����ϴ�.");
						}
						break;						
					}
				
			}
			else if ( choice == 3 ) {
				System.out.println("������ ��¥�� �Է��ϼ���.");
				while(true){
					String deleteCreatedate = input.next();
					if (this.result = this.deletetodoByCreatedate(deleteCreatedate)){
							this.todoList.remove(getInfo(deleteCreatedate));
							System.out.println("�����߽��ϴ�.");
							break;
						}
						else{
							System.out.println("�����ϴ�.");
							break;
						}
					
				}
			}
		else if ( choice == 4 ) {
				while(true){
					System.out.println("1.������¥���� / 2.���Ѽ��� / 3.�������");
					try{
						int what = input.nextInt();
						this.settodoByWhatItem(what);
						break;
					}
					catch(InputMismatchException ime) {
						System.out.println("�߸��Է��߽��ϴ�.");
					}
				}
			}
			else {
				System.out.println("�ٽ��Է����ּ���.");
			}
		}
	}

	public boolean checkScanner( String checkScan, String whatString ) {
		if ( !whatString.matches(checkScan) ) {
			System.out.println("���Է����ּ���.");
			return true;
		}
		else {
			return false;
		}
	}

	public void addNewTodo(TodoList todo) {
		this.todoList.add(todo);
	}

	public boolean gettodoByCreatedate( String createdate ) {
		for ( TodoList todo : this.todoList ) {
			if ( todo.getCreatedate().equals(createdate) ){
				this.todo = todo;
				return true;
			}
		}
		return false;
	}
	
	public void printInfo(){
		System.out.println(this.todo.getCreatedate());
		System.out.println(this.todo.getDue());
		System.out.println(this.todo.getDescription());
	}
	
	public boolean deletetodoByCreatedate( String createdate ) {
		for ( TodoList todo : this.todoList ) {
			if( todo.getCreatedate().equals(createdate) ) {
				return true;
			}
		}
		return false;
	}
	

	public TodoList getInfo( String createdate ) {
		for ( TodoList todo : this.todoList ) {
			if ( todo.getCreatedate().equals(createdate) ){
				this.todo = todo;
				return todo;
			}
		}
		return new TodoList();
	}


	public void settodoByWhatItem(int Choice){

		String oldCreatedate = "";
		String newCreatedate = "";
		
		String oldDue = "";
		String newDue = "";
		
		String oldDescription = "";
		String newDescription = "";
		
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
			if (Choice == 1) {
				System.out.println("������ ������¥�� �Է��ϼ���.");
				oldCreatedate = input.next();
				System.out.println("���ο� ������¥�� �Է��ϼ���.");
				newCreatedate = input.next();
				settodoByCreatedate(oldCreatedate, newCreatedate);
				break;
					
			}
			else if (Choice == 2) {
				System.out.println("������ ������ �Է��ϼ���.");
				oldDue = input.next();
				System.out.println("���ο� ������ �Է��ϼ���.");
				newDue = input.next();
				settodoByDue(oldDue, newDue);
				break;
			}
			else if (Choice == 3) {
				System.out.println("������ ������ �Է��ϼ���.");
				oldDescription = input.next();
				System.out.println("���ο� ������ �Է��ϼ���.");
				newDescription = input.next();
				settodoByDescription(oldDescription,newDescription);
				break;
			}
		
			else {
				System.out.println("�ٽ��Է��ϼ���.");
			}
	}
}

	public TodoList settodoByCreatedate( String oldCreatedate, String newCreatedate) {
		for ( TodoList todo : this.todoList ) {
			if( todo.getCreatedate().equals(oldCreatedate) ) {
				todo.setCreatedate(newCreatedate);
				System.out.println("�����Ϸ�");
				return  todo;
			}
			else {
				System.out.println("����.");
			}
		}
		return new TodoList();
	}
	
	public TodoList settodoByDue( String oldDue, String newDue) {
		for ( TodoList todo : this.todoList ) {
			if( todo.getDue().equals( oldDue) ) {
				todo.setDue(newDue);
				System.out.println("�����Ϸ�Ǿ����ϴ�.");
				return  todo;
			}
			else {
				System.out.println("�����ϴ�.");
			}
		}
		return new TodoList();
	}
	
	public TodoList settodoByDescription( String oldDescription, String newDescription) {
		for ( TodoList todo : this.todoList ) {
			if( todo.getDescription().equals (oldDescription)) {
				todo.setDescription(newDescription);
				System.out.println("�����Ϸ�Ǿ����ϴ�");
				return  todo;
			}
			else {
				System.out.println("�����ϴ�.");
			}
		}
		return new TodoList();
	}
	


}