
public class Bot implements IChatMember{

	private IMessageMediator mediator;
	private String name;
	private String controlWord;
	
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
	public IMessageMediator getMediator() {
		return this.mediator;
	}
	
	@Override
	public void setControlWord(String word) {
		this.controlWord = word;
		this.name = "BOT["+ controlWord.toUpperCase() +"]";
	}
	
	public boolean isForbiddenWord(String forbiddenWord) {
    	return forbiddenWord.equals(controlWord);
    }
	
	public boolean isMessageValid(String message, IChatMember member) {
		if (isForbiddenWord(message)) {
			this.mediator.removeChatMember(member);
			informChat(member.getName(), message);
			return false;
		}
		return true;
	}
	
	private void informChat(String name, String message) {
		this.mediator.sendMessage(this.name + " removed " + name + " from the chat because " + name + " said " + message + " which is forbidden.", this);		
	}
	
	@Override
	public void setMediator() {
		// REMOVING THE MEDIATOR
		this.mediator = null;
	}
	
	// BOT CAN'T RECEIVE NOR SEND MESSAGES;
	
	@Override
	public void receive(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(String message) {
		// TODO Auto-generated method stub
		
	}

}
