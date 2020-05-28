
public class User implements IChatMember {
	
	private IMessageMediator mediator;
    private String name;

	@Override
	public void send(String message) {
		if (mediator != null) {
			System.out.println(this.name + " sent: " + message);
			mediator.sendMessage(message, this);
		}
	}
	
	@Override
	public void receive(String message) {
		System.out.println(this.name + " received: " + message);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setMediator(IMessageMediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setMediator() {
		// REMOVING THE MEDIATOR
		this.mediator = null;
	}

	@Override
	public IMessageMediator getMediator() {
		return this.mediator;
	}

	// THE USER CAN'T SET THE CONTROL WORD
	@Override
	public void setControlWord(String controlWord) {
		// TODO Auto-generated method stub
		
	}

}
