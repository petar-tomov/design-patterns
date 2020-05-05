
public class MainCommand {

	public static void main(String[] args) {
		
		Trainee trainee = new Trainee("Misho");
		Instructor instructor = new Instructor("Martin");
		
		Viewer firstViewer = new Viewer("Ivan");
		Viewer secondViewer = new Viewer("Mitko");
		Viewer thirdViewer = new Viewer("Jordan");
		
		ICommand standUpCommand = new StandUpCommand(trainee);
		
		ICommand layDownCommand = new LayDownCommand(trainee);
		
		trainee.addObserver(firstViewer);
		trainee.addObserver(secondViewer);
		trainee.addObserver(thirdViewer);
		
		instructor.setCommand(layDownCommand);
		instructor.giveCommand();
		
		instructor.setCommand(standUpCommand);
		instructor.giveCommand();
		
	}

}
