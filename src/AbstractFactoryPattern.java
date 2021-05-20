/*
 * 抽象工廠方法模式
 */
public class AbstractFactoryPattern {
	public static void main(String[] args) {
	    SampleFactory Onefactory = new OneFactory(); 
	    Onefactory.CreateProductA();
	    Onefactory.CreateProductB();
	    
	    SampleFactory Twofactory = new TwoFactory(); 
	    Twofactory.CreateProductA();
	    Twofactory.CreateProductB();
    }
}

abstract class SampleProduct{}

class ProductA1 extends SampleProduct{
	 public ProductA1() {
		 System.out.println("生成物件類型A1");
    }
}

class ProductB1 extends SampleProduct{
	 public ProductB1() {
		 System.out.println("生成物件類型B1");
    }
}

class ProductA2 extends SampleProduct{
	 public ProductA2() {
		 System.out.println("生成物件類型A2");
   }
}

class ProductB2 extends SampleProduct{
	 public ProductB2() {
		 System.out.println("生成物件類型B2");
   }
}

interface SampleFactory {
	SampleProduct CreateProductA();
	SampleProduct CreateProductB();
}


class OneFactory implements SampleFactory{

	public OneFactory() {
		 System.out.println("One工廠產生");
    }

	@Override
	public SampleProduct CreateProductA() {
		return new ProductA1();
	}

	@Override
	public SampleProduct CreateProductB() {
		return new ProductB1();
	}
}

class TwoFactory implements SampleFactory{

	public TwoFactory() {
		 System.out.println("Two工廠產生");
    }

	@Override
	public SampleProduct CreateProductA() {
		return new ProductA2();
	}

	@Override
	public SampleProduct CreateProductB() {
		return new ProductB2();
	}
}
