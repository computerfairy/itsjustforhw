
public class Contact implements Comparable<Contact> {
	String name;
	String number;
	String email;

	public Contact(String name, String number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Contact cont) {
		return name.compareToIgnoreCase(cont.getName());
	}

	@Override
	public String toString() {
		String description;

		description = name + "	" + number + "	" + email;
		
		return description;
	}

}
