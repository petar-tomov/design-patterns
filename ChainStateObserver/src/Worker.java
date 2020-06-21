
public class Worker implements IObserver {

	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void update(IObservable employee) {
		if (employee.getUpdate() == null) {
			System.out.println("No state");
			return;
		}
		
		if (employee.getUpdate().equals("PREPARING"))
		{
			System.out.println(this.getName() + "'s package from " + employee.getName() + " is heading to the warehouse.");
			employee.getState().resetState(employee);		
		}
	}

}
