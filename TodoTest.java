import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class TodoTest {

	@Test
	void testAddNewTodo() {
		TodoList todo = new TodoList();
		assertNotNull(todo);
	}

	@Test
	void testdeletetodoByCreatedate() {
		TodoList todo = new TodoList();
		String createdate = todo.getCreatedate();
		assertNull(createdate);
		
	}

}
