
public class PreparingState implements IState {

	private String stateName = "PREPARING";
	
	@Override
	public void applyState(IContext context) {
		context.setState(this);
	}

	@Override
	public void resetState(IObservable obs) {
		
		WaitingState waiting = new WaitingState();
		obs.setState(waiting);
	}

	@Override
	public String getStateName() {
		return this.stateName;
	}

}
