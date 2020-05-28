
public interface IChatMember {
	
	public void receive(String message);
	
	public void send(String message);
	
	public void setName(String name);
	
	public String getName();
	
	public void setMediator(IMessageMediator mediator);
	
	public void setMediator();
	
	public IMessageMediator getMediator();

	public void setControlWord(String controlWord);
	
}
