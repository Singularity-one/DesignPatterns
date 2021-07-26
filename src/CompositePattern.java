import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
	public static void main(String[] args) {
		  Employee CEO = new Employee("Boss",100,"製造魔王城");

	      Employee headSales = new Employee("Demon",90,"領軍");

	      Employee headMarketing = new Employee("Necromancer",90,"策略");

	      Employee clerk1 = new Employee("Witch",80, "爆破");
	      Employee clerk2 = new Employee("Slime",70, "腐蝕");

	      Employee salesExecutive1 = new Employee("Orc",80,"護衛");
	      Employee salesExecutive2 = new Employee("Goblin",70,"偵查");

	      CEO.add(headSales);
	      CEO.add(headMarketing);

	      headSales.add(salesExecutive1);
	      headSales.add(salesExecutive2);

	      headMarketing.add(clerk1);
	      headMarketing.add(clerk2);

	      //print all employees of the organization
	      System.out.println(CEO); 
	      System.out.println("-------------------");
	      
	      for (Employee headEmployee : CEO.getSubordinates()) {
	         System.out.println(headEmployee);
	         for (Employee employee : headEmployee.getSubordinates()) {
	            System.out.println(employee);
	         }
	         System.out.println("-------------------");
	      }		
	}
}

class Employee {
	private String name;
	   private int lv;
	   private String ability;
	   private List<Employee> subordinates;

	   public Employee(String name,int lv, String ability) {
	      this.name = name;
	      this.lv = lv;
	      this.ability = ability;
	      subordinates = new ArrayList<Employee>();
	   }

	   public void add(Employee e) {
	      subordinates.add(e);
	   }

	   public void remove(Employee e) {
	      subordinates.remove(e);
	   }

	   public List<Employee> getSubordinates(){
	     return subordinates;
	   }

	@Override
	public String toString() {
		return "Employee [name=" + name + ", lv=" + lv + ", ability=" + ability+"]";
	}  
}


