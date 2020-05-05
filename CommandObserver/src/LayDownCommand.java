
public class LayDownCommand implements ICommand {

	private Trainee trainee;
	
	public LayDownCommand(Trainee trainee) {
		this.trainee = trainee;
	}
	
	@Override
	public void execute() {
		this.trainee.layDown();
	}

}