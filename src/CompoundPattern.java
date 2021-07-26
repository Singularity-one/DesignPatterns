/*
 * 複合模式
*/
public class CompoundPattern {
	public static void main(String[] args) {
		  StoreA model  = retriveStore();

	      
		  StoreAView view = new StoreAView();

		  StoreController controller = new StoreController(model, view);

	      controller.updateView();

	      
	      controller.setStoreAName("B商店");
	      controller.setStoreAData("特賣B");

	      controller.updateView();
    }
	
	private static StoreA retriveStore(){
		   StoreA store = new StoreA();
		   store.setName("A商店");
		   store.setData("特賣A");
	       return store;
	}
}

class StoreA {
	   private String name;
	   private String data;
	   
	   public String getName() {
	      return name;
	   }
	   
	   public void setName(String name) {
	      this.name = name;
	   }
	   
	   public String getData() {
	      return data;
	   }
	   
	   public void setData(String data) {
	      this.data = data;
	   }
}

class StoreAView {
	   public void printStoreAData(String name, String data){
	      System.out.println("Store: ");
	      System.out.println("Name: " + name);
	      System.out.println("Data: " + data);
	   }
}

class StoreController {
	   private StoreA model;
	   private StoreAView view;

	   public StoreController(StoreA model, StoreAView view){
	      this.model = model;
	      this.view = view;
	   }

	   public void setStoreAName(String name){
	      model.setName(name);		
	   }

	   public String getStoreAName(){
	      return model.getName();		
	   }

	   public void setStoreAData(String data){
	      model.setData(data);		
	   }

	   public String getStoreAData(){
	      return model.getData();		
	   }

	   public void updateView(){				
	      view.printStoreAData(model.getName(), model.getData());
	   }	
}

