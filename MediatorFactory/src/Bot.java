
public class Bot implements IChatMember{

	private IMessageMediator mediator;
	private String name;
	private String forbiddenWord;
	
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
	
	@Override
	public void setControlWord(String word) {
		this.forbiddenWord = word;
		this.name = "BOT["+ forbiddenWord +"]";
	}
	
	public boolean isForbiddenWord(String word) {
    	return word.equals(forbiddenWord);
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
		this.mediator.sendMessage(this.name + " removed: " + name + " from the chat because he said: " + message + " which is forbidden.", this);		
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
