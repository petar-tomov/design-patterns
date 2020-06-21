
public class WaitingState implements IState {
	
	private String stateName = "WAITING";

	@Override
	public void applyState(IContext context) {
		context.setState(this);
	}

	@Override
	public void resetState(IObservable obs) {
		// resetState() doesn't work for the Waiting state;
	}

	@Override
	public String getStateName() {
		return this.stateName;
	}

}
