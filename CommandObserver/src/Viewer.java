
public class Viewer implements IObserver {

	private String name;
	private IObservable trainee;
	private boolean standUp;
	
	public Viewer(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	private String getCurrentExercise() {
		return standUp ? "stood up." : "laid down.";
	}
	
	@Override
	public void update() {
		standUp = trainee.getUpdate();
		System.out.println(this.name + " " + getCurrentExercise());
	}

	@Override
	public void setTrainee(IObservable trainee) {
		this.trainee = trainee;
	}

	public IObservable getTrainee() {
		return trainee;
	}
	
}
	
