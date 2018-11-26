
public class Contacts {
	String name; //연락처 이름
    String number; //연락처 전화번호
    String mail; //연락처 이메일
    
    public Contacts(String name, String number, String mail){ //생성자
        this.name = name;
        this.number = number;
        this.mail = mail;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getNumber(){
        return number;
    }
    
    public void SetNumber(String number){
        this.number = number;
    }

     public String getMail(){
        return mail;
    }

    public void setMail(String mail){
        this.mail = mail;
    }
}
