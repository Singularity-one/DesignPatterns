import java.util.*;

public class ObserverPattern {
	public static void main(String[] args) {
		Store store =new Store();
		
		User userA =new User("A");
		User userB =new User("B");
		
		store.addObserver(userA);
		store.addObserver(userB);
		
		store.sendChange("特賣1");
		
		store.rmoveObserver(userB); //B不訂閱
		
		store.sendChange("特賣2");
    }
}

interface Subject {
    public void addObserver(Observer o);
    public void rmoveObserver(Observer o);
    public void notifyObservers();
}

interface Observer{
    public void showdata(String data); 
    
    public void setdata(String data); 
}


class Store implements Subject{
	 private ArrayList observers;
     private String data;
     
     public Store() {
         observers =new ArrayList();
     }
     
     @Override
     public void addObserver(Observer o) { //註冊時user時 加到ArrayList後面
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
             observer.showdata(data);
         }
     }
     
     public void sendChange(String data) { //商家更新情報通知user
    	 this.data=data;
    	 for(int i=0;i < observers.size();i++) {
             Observer observer =(Observer)observers.get(i);
             observer.setdata(data);
         }
         notifyObservers();
     } 
}


class User implements Observer{
    private String name;
    private String data;
  
    public User(String name) {
        this.name= name;
    }	
      
    @Override
    public void showdata(String data) {
    	System.out.println("通知使用者"+name+":"+data);
    }

	@Override
	public void setdata(String data) {
		this.data= data;
	}      
}



