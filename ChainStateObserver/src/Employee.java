import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements IContext, IObservable {
	
	public static int CITY_EMPLOYEE = 1;
	public static int COUNTRY_EMPLOYEE = 2;
	public static int INTERNATIONAL_EMPLOYEE = 3;
	
	protected IState state;
	protected Employee next;
	protected String name;
	protected int level;
	
	protected List<IObserver> observers = new ArrayList<IObserver>();
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setNextEmployee(Employee nextEmployee) {
		this.next = nextEmployee;
	}

	public void acceptShipment(int level) {
		System.out.println("** Order level[" + level + "] is currently being processed by " + this.name);
		
		//if employee can handle order, he/she takes it
		if(this.level >= level) {
			this.handleOrder();
		}
		
		//else the order goes to the next employee
		else if(this.next != null) {
			System.out.println(this.name + " couldn't handle the order.");
			this.next.acceptShipment(level);
		}
	}
	
	abstract protected void handleOrder();
}
