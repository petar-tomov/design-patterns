
public interface IMessageMediator {
	
    public void addChatMember(IChatMember member);
    
    public void removeChatMember(IChatMember member);
    
    public void sendMessage(String message, IChatMember member);
    
}
