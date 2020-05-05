import java.util.ArrayList;

public class Trainee implements IObservable {
	
	private String name;
	private String exercise;
	private boolean standUp;
	private ArrayList<IObserver> viewers = new ArrayList<>();
	
	public Trainee(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getExercise() {
		return exercise;
	}
	
	public void standUp() {
		this.standUp = true;
		this.exercise = "Stand Up";
		printInfo();
	}
	
	public void layDown() {
		this.standUp = false;
		this.exercise = "Lay Down";
		printInfo();
	}
	
	@Override
	public void addObserver(IObserver viewer) {
		this.viewers.add(viewer);
		viewer.setTrainee(this);	
	}
	
	@Override
	public void deleteObserver(IObserver viewer) {
		this.viewers.remove(viewer);
	}
	
	@Override
	public void notifyObservers() {
		for (IObserver trainee : viewers) {
			trainee.update();
		}
		System.out.println();
	}
	
	@Override
	public boolean getUpdate() {
		return this.standUp;
	}
	
	public void printInfo() {
		if(standUp) {
			System.out.println(getName() + " stood up.");
		} else {
			System.out.println(getName() + " laid down.");
		}
		
		notifyObservers();
	}
	
}
