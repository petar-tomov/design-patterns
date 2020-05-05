
public class StandUpCommand implements ICommand {

	private Trainee trainee;
	
	public StandUpCommand(Trainee trainee) {
		this.trainee = trainee;
	}
	
	@Override
	public void execute() {
		this.trainee.standUp();
	}

}
