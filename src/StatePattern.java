/*
 * 狀態模式
 */
public class StatePattern {
	public static void main(String[] args) {
		 Context c = new Context();
		 c.setState(new StateA());
         c.Request();
         c.setState(new StateB());
         c.Request();

    }
}

class Context{ //環境
    private State state;

    public void setState(final State state) {
        this.state = state;
    }
    
    public void Request()
    {
        state.Handle();
    }
}

abstract class State
{
    public abstract void Handle();
}

class StateA extends State
{
	@Override
	public void Handle() {
		System.out.println("狀態A");
	}
}

class StateB extends State
{

	@Override
	public void Handle() {
		System.out.println("狀態B");
	}
}
