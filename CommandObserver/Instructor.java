
public class Instructor {
	
	private ICommand command;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Instructor(String name) {
		this.name = name;
	}
		
	public void setCommand(ICommand command) {
		this.command = command;
	}
	
	public void giveCommand() {
		System.out.println(this.name + " gave a command.");
		
		command.execute();
	}

}
