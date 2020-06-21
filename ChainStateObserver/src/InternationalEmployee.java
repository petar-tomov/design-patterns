
public class InternationalEmployee extends Employee {

	public InternationalEmployee() {
		this.level = Employee.INTERNATIONAL_EMPLOYEE;
	}
	
	@Override
	public IState getState() {
		return state;
	}

	@Override
	public void setState(IState state) {
		this.state = state;		
		System.out.println(this.name + " is " + this.state.getStateName());
	}

	@Override
	public void subscribe(IObserver obs) {
		this.observers.add(obs);
	}

	@Override
	public void unsubscribe(IObserver obs) {
		this.observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for(IObserver observer : this.observers) {
			observer.update(this);
		}
	}

	@Override
	public String getUpdate() {
		return this.state.getStateName();
	}

	@Override
	protected void handleOrder() {
		System.out.println("Employee[" + this.name + "] has taken the order.");
		
		PreparingState preparingState = new PreparingState();
		this.setState(preparingState);
		
		notifyObservers();
	}

}
