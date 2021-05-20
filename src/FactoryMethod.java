/*
 * 工廠方法模式
 */
public class FactoryMethod {
	public static void main(String[] args) {
		
		//
		Product theProduct =null;

		//
		Factory factoryA =new FactoryA();
		theProduct =factoryA.FactoryMethod();
		
		Factory factoryB =new FactoryB();
		theProduct =factoryB.FactoryMethod();
    }
}

abstract class Product{}

abstract class Factory {
    public abstract  Product FactoryMethod();
}

class ProductA extends Product{
	 public ProductA() {
		 System.out.println("生成物件類型A");
     }
}

class ProductB extends Product{
	 public ProductB() {
		 System.out.println("生成物件類型B");
     }
}

class FactoryA extends Factory{

	public FactoryA() {
		 System.out.println("A工廠產生");
    }
	
	
	@Override
	public Product FactoryMethod() {
		return new ProductA();
	} 
}

class FactoryB extends Factory{
	
	public FactoryB() {
		 System.out.println("B工廠產生");
	}
	
	
	@Override
	public Product FactoryMethod() {
		return new ProductB();
	} 
}


