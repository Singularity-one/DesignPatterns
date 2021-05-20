/*
 * 樣板方法模式
 */
public class TemplateMethodPattern {
	 public static void main(String[] args) {
		 PotionOfStrength potionA =new PotionOfStrength();
		 potionA.chose=false;
		 potionA.prepareRecipe();
		 
		 PotionOfEnergy potionB =new PotionOfEnergy();
		 potionB.chose=true;
		 potionB.prepareRecipe();
	}
}

abstract class Potion{  //藥水是一個抽象類別
	
	boolean chose = false;
	
	void prepareRecipe() {
		brew();
		if(chose) {
			addCondiments();
		}
		pourInCup();
	}
	
	abstract void brew(); //調配
	
	abstract void addCondiments();  //加入調味
	
	void pourInCup() {
		System.out.println("裝杯");
	}
}

class PotionOfStrength extends Potion{
	
	PotionOfStrength(){
		System.out.println("製作力量藥水");
	}
	
	@Override
	void brew() {
		System.out.println("加入B+C群維他命");
	}

	@Override
	void addCondiments() {
		System.out.println("放糖");
	}
}

class PotionOfEnergy extends Potion{
	
	PotionOfEnergy(){
		System.out.println("製作精力藥水");
	}
	
	@Override
	void brew() {
		System.out.println("加入精力劑");
	}

	@Override
	void addCondiments() {
		System.out.println("放糖");
	}
}




