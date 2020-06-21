
public interface IObservable {
	
	public void subscribe(IObserver obs);
	
	public void unsubscribe(IObserver obs);
	
	public void notifyObservers();
	
	public String getUpdate();
	
	public String getName();
	
	public IState getState();
	
	public void setState(IState state);
	
}
