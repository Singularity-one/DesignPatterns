/*
 * 策略模式
 */
public class StrategyPattern {
	public static void main(String[] args) {
		StrategyContext strategyContext =new StrategyContext();
		
		strategyContext.setStrategy(new ConcreteStrategyA());
		strategyContext.ContextInterface();
		
		strategyContext.setStrategy(new ConcreteStrategyB());
		strategyContext.ContextInterface();
		
    }
}

abstract class Strategy{
	public abstract void AlgorithmInterface();
}

class ConcreteStrategyA extends Strategy{

	@Override
	public void AlgorithmInterface() {
		System.out.println("執行ConcreteStrategyA的AlgorithmInterface");
	}
}

class ConcreteStrategyB extends Strategy{

	@Override
	public void AlgorithmInterface() {
		System.out.println("執行ConcreteStrategyB的AlgorithmInterface");
	}
}

class StrategyContext {
	
	private Strategy strategy ;
	
	public void setStrategy(Strategy strategy) {
		this.strategy =strategy;
	}
	
	public void ContextInterface() {
		strategy.AlgorithmInterface();
	}
	
}
