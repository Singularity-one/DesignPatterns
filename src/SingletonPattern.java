/*
 * 單例模式
 */
public class SingletonPattern {
	public static void main(String[] args) {

	}
}

class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        // 第一次被呼叫的時候再建立物件
        if(instance == null){
            instance = new Singleton();
        } 
        return instance;
    }
}

class SingletonSyn extends Thread{
	private static SingletonSyn instance;

    private SingletonSyn(){ }

    // 多執行緒時使用synchronized保證單一
    public static SingletonSyn getInstance(){
        if(instance == null){
            synchronized(SingletonSyn.class){
                if(instance == null){
                    instance = new SingletonSyn();
                }    
            }
        } 
        return instance;
    }
}

class SingletonVol extends Thread{
	//Java5 以上volatile
	private volatile static SingletonVol instance;

    private SingletonVol(){ }

    public static SingletonVol getInstance(){
        if(instance == null){
            synchronized(SingletonVol.class){
                if(instance == null){
                    instance = new SingletonVol();
                }    
            }
        } 
        return instance;
    }
}
