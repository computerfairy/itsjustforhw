import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ContactMenu {
	private ArrayList<Contact> contactList;
	Scanner scan = new Scanner(System.in);

	public ContactMenu() {
		contactList = new ArrayList<Contact>();
		Scanner sc = new Scanner(System.in);
		int menuChoose = -1;

		do {
			if (contactList.isEmpty()) {
				printContactListIsEmpty();
			} else {
				Collections.sort(contactList);
				printContactList();
			}

			printContactMenu();

			while (true) {
				try {
					menuChoose = sc.nextInt();
					break;
				} catch (Exception e) {
					sc = new Scanner(System.in);

					System.out.println();
					System.out.println("잘못 입력하셨습니다.");
					System.out.print("원하는 메뉴를 입력하세요: ");
				}
			}

			System.out.println();

			switch (menuChoose) {
			case 1:
				createContact();
				break;
			case 2:
				changeContact();
				break;
			case 3:
				deleteContact();
				break;
			case 4:
				main_menu.main(null);
				break;
			default:
				System.out.println("다시 입력해주세요");
				System.out.println("원하는 메뉴를 입력하세요: ");
				menuChoose = sc.nextInt();
				break;
			}

		} while (menuChoose != 4);
	}

	public void printContactListIsEmpty() {
		System.out.println("연락처가 없습니다.");
		System.out.println();
	}

	public void printContactList() {
		System.out.println();

		for (int i = 0; i < contactList.size(); i++) {
			System.out.println(contactList.get(i).toString());
		}

		System.out.println();
	}

	public void printContactMenu() {
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 메인 메뉴로 돌아가기");
		System.out.println();
		System.out.print("원하는 메뉴를 입력하세요: ");
	}

	public void createContact() {
		String name;
		String number;
		String email;

		System.out.print("이름: ");
		name = scan.nextLine();
		System.out.print("번호: ");
		number = scan.nextLine();
		System.out.print("이메일: ");
		email = scan.nextLine();

		Contact contact = new Contact(name, number, email);

		contactList.add(contact);
	}

	public void changeContact() {
		String name;
		String newName, newNumber, newEmail;

		System.out.print("수정하고 싶은 사람의 이름을 입력하세요: ");
		name = scan.nextLine();

		for (Contact con : contactList) {
			if (name.equals(con.getName())) {
				System.out.println();
				System.out.println(con.toString());
				System.out.println();
				
				System.out.println("수정할 내용을 입력하세요");

				System.out.print("이름: ");
				newName = scan.nextLine();
				System.out.print("번호: ");
				newNumber = scan.nextLine();
				System.out.print("이메일: ");
				newEmail = scan.nextLine();

				con.setName(newName);
				con.setNumber(newNumber);
				con.setEmail(newEmail);
			}
		}

	}

	public void deleteContact() {
		String name;

		System.out.print("지우고 싶은 이름을 입력하세요: ");
		name = scan.nextLine();

		Iterator<Contact> iter = contactList.iterator();
		while (iter.hasNext()) {
			Contact cont = iter.next();

			if (name.equals(cont.getName()))
				iter.remove();
		}

	}

	public static void main(String[] args) {
		new ContactMenu();
	}

}
