
public interface IState {
	
	public void applyState(IContext context);
	
	public void resetState(IObservable obs);
	
	public String getStateName();
	
}
