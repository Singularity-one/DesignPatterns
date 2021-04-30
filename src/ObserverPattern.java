import java.util.ArrayList;

public class ObserverPattern {
	public static void main(String[] args) {
		Information information =new Information();
		
		User userA =new User("A",information);
		User userB =new User("B",information);
		
		information.sendChange("hello!!");
    }
}

interface Observer{
	public void updata(String data); //當data改變時 傳送給User
}

interface DisplayElement{
	public void display(); //User顯示資料呼叫這個方法
}

interface Subject {
	public void registerObserver(Observer o);
	public void rmoveObserver(Observer o);
	public void notifyObservers();
}

class Information implements Subject{
	private ArrayList observers;
    private String data;
    
    public Information() {
    	observers =new ArrayList();
    }
    
    @Override
    public void registerObserver(Observer o) { //註冊時user時 加到ArrayList後面
    	observers.add(o);
    }
    
    @Override
	public void rmoveObserver(Observer o) { //user想取消 從ArrayList刪除
		int i =observers.indexOf(o);
		if(i>=0) {
			observers.remove(i);
		}
	}
	
    @Override
	public void notifyObservers() {  
		for(int i=0;i < observers.size();i++) {
			Observer observer =(Observer)observers.get(i);
			observer.updata(data);
		}
	}
	
	public void sendChange() { //商家更新情報通知user
		notifyObservers();
	}
	
	public void sendChange(String data) {
		this.data =data;
		sendChange();
	}
}

class User implements Observer, DisplayElement{
	private String name;
	private Subject information;
	private String  data;
  
	public User(String name ,Subject information) {
		this.name = name;
		this.information = information;
		information.registerObserver(this);
	}	
  	
	@Override
	public void updata(String data) {
		this.data = data;
		display();
	}
  	
  	@Override
  	public void display() {
  		System.out.println("使用者:"+name+"得到情報:"+data);
  	}
}
