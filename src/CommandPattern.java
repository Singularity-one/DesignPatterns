import java.util.ArrayList;
import java.util.List;

/*
 * 命令模式
 */
public class CommandPattern {
	public static void main(String[] args) {
		Invoker invoker =new Invoker();
		
		Command command_A =new ConcreteCommand_A(new Receiver_A(),"你好");
		invoker.addCommand(command_A);
		
		Command command_B =new ConcreteCommand_B(new Receiver_B(),100);
		invoker.addCommand(command_B);
		
		//執行
		invoker.ExecuteCommand();
	}
}

class Receiver_A{
	
	void action(String Command) {
		System.out.println("Receiver_A:"+Command);
	}
}

class Receiver_B{
	void action(int Command) {
		System.out.println("Receiver_B:"+Command);
	}
}

interface Command {
     public void execute();
     public void undo();
}

class ConcreteCommand_A implements Command{
	
	Receiver_A receiver_A =new Receiver_A();
	String Command ="";
	
	public ConcreteCommand_A(Receiver_A receiver,String command) {
		receiver_A =receiver;
		Command =command;
	}
	
	@Override
	public void execute() {
		receiver_A.action(Command);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
	}
    
}

class ConcreteCommand_B implements Command{
	
	Receiver_B receiver_B =new Receiver_B();
	int Command =0;
	
	public ConcreteCommand_B(Receiver_B receiver,int command) {
		receiver_B =receiver;
		Command =command;
	}
	
	@Override
	public void execute() {
		receiver_B.action(Command);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
	}
}

class Invoker{
	 List<Command> commandList = new ArrayList<Command>();

	 //加入命令
	 public void addCommand(Command command) {
		 commandList.add(command);
	 }
	 
	 //執行命令
	 public void ExecuteCommand() {
		 //執行
		 commandList.forEach(item->{
			 item.execute();
	        });
		 //清空
		 commandList.clear();
	 }
}
