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
			
			System.out.println("1.TO-DO 생성 / 2. TO-DO 보기 / 3. TO-DO 삭제 / 4. TO-DO 수정");
			
			try{
				choice = input.nextInt();
			}
			catch(InputMismatchException ime) {
				System.out.println("잘못입력했습니다.");
				startProgram();
			}
			
			if( choice == 1 ) {
				todo = new TodoList();
				System.out.println("생성날짜/기한/내용 을 순서대로 입력하세요.");
		
				String createdate = input.next();
				todo.setCreatedate(createdate);
				todo.setDue( input.next() );
				todo.setDescription( input.nextLine() );
				this.addNewTodo(todo);
			}
			else if ( choice == 2 ) {
				while(true){
					System.out.println("검색할 날짜를 입력하세요.");
					String searchCreatedate = input.next();
					if(this.result = this.gettodoByCreatedate(searchCreatedate) ){
							printInfo();
						}
						else {
							System.out.println("없습니다.");
						}
						break;						
					}
				
			}
			else if ( choice == 3 ) {
				System.out.println("삭제할 날짜를 입력하세요.");
				while(true){
					String deleteCreatedate = input.next();
					if (this.result = this.deletetodoByCreatedate(deleteCreatedate)){
							this.todoList.remove(getInfo(deleteCreatedate));
							System.out.println("삭제했습니다.");
							break;
						}
						else{
							System.out.println("없습니다.");
							break;
						}
					
				}
			}
		else if ( choice == 4 ) {
				while(true){
					System.out.println("1.생성날짜수정 / 2.기한수정 / 3.내용수정");
					try{
						int what = input.nextInt();
						this.settodoByWhatItem(what);
						break;
					}
					catch(InputMismatchException ime) {
						System.out.println("잘못입력했습니다.");
					}
				}
			}
			else {
				System.out.println("다시입력해주세요.");
			}
		}
	}

	public boolean checkScanner( String checkScan, String whatString ) {
		if ( !whatString.matches(checkScan) ) {
			System.out.println("재입력해주세요.");
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
				System.out.println("기존의 생성날짜를 입력하세요.");
				oldCreatedate = input.next();
				System.out.println("새로운 생성날짜를 입력하세요.");
				newCreatedate = input.next();
				settodoByCreatedate(oldCreatedate, newCreatedate);
				break;
					
			}
			else if (Choice == 2) {
				System.out.println("기존의 기한을 입력하세요.");
				oldDue = input.next();
				System.out.println("새로운 기한을 입력하세요.");
				newDue = input.next();
				settodoByDue(oldDue, newDue);
				break;
			}
			else if (Choice == 3) {
				System.out.println("기존의 내용을 입력하세요.");
				oldDescription = input.next();
				System.out.println("새로운 내용을 입력하세요.");
				newDescription = input.next();
				settodoByDescription(oldDescription,newDescription);
				break;
			}
		
			else {
				System.out.println("다시입력하세요.");
			}
	}
}

	public TodoList settodoByCreatedate( String oldCreatedate, String newCreatedate) {
		for ( TodoList todo : this.todoList ) {
			if( todo.getCreatedate().equals(oldCreatedate) ) {
				todo.setCreatedate(newCreatedate);
				System.out.println("수정완료");
				return  todo;
			}
			else {
				System.out.println("없다.");
			}
		}
		return new TodoList();
	}
	
	public TodoList settodoByDue( String oldDue, String newDue) {
		for ( TodoList todo : this.todoList ) {
			if( todo.getDue().equals( oldDue) ) {
				todo.setDue(newDue);
				System.out.println("수정완료되었습니다.");
				return  todo;
			}
			else {
				System.out.println("없습니다.");
			}
		}
		return new TodoList();
	}
	
	public TodoList settodoByDescription( String oldDescription, String newDescription) {
		for ( TodoList todo : this.todoList ) {
			if( todo.getDescription().equals (oldDescription)) {
				todo.setDescription(newDescription);
				System.out.println("수정완료되었습니다");
				return  todo;
			}
			else {
				System.out.println("없습니다.");
			}
		}
		return new TodoList();
	}
	


}