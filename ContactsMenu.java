import java.util.*;

public class ContactsMenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String name; //연락처 항목-이름
        String number; //연락처 항목-전화번호
        String mail; //연락처 항목-이메일
        int choose = -1; //연락처 내부 메뉴 선택
        List<Contacts> contactsList = new ArrayList<Contacts>(); //연락처 리스트
        
       do{
           //연락처 보이기. 이름 오름차순 정렬
          /* Collections.sort(contactsList, new Comparator<Contacts>(){
               public int compare(Contacts contact1, Contacts contact2){
                   if(contact1.getName() > contact2.getName()){
                       return 1;
                   }else if(contact1.getName() < contact2.getName()){
                       return -1;
                   }else{
                       return 0;
                   }
               }
           
           });*/
    	   
    	   
           
           for(int i = 0; i < contactsList.size(); i++){
               System.out.println(contactsList.get(i).getName() + "  " + contactsList.get(i).getNumber() + " " + contactsList.get(i).getMail());
           }
           
           System.out.println("1. 연락처 추가");
           System.out.println("2. 연락처 수정");
           System.out.println("3. 연락처 삭제");
           System.out.println("4. 메인 메뉴로 돌아가기");
           System.out.println();
           System.out.println("원하는 메뉴를 입력하세요: ");
           
           choose = sc.nextInt();
           
           switch(choose){
               case 1: 
                   CreateContacts();
                   break;
               case 2:
                   ChangeContacts();
                   break;
               case 3:
                   DeleteContacts();
                   break;
               case 4:
                   //return; 메인 메뉴로 돌아감abstract
               default:
                   System.out.println("다시 입력해주세요");
                   System.out.println("원하는 메뉴를 입력하세요: ");
                    choose = sc.nextInt();
                   break;
           }

       }while(choose != 4);

	}
	
	public void CreateContacts(){
        
        // 영화 파일 참고
    }
    
    public void ChangeContacts(){  
        
    }
    
    public void DeleteContacts(){
    
    }

}
