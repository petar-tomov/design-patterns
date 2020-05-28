import java.util.ArrayList;

public class ChatMessageMediator implements IMessageMediator {

	private ArrayList<IChatMember> chatMembers;
	
	public ChatMessageMediator() {
        this.chatMembers = new ArrayList<>();
    }
	
	@Override
	public void addChatMember(IChatMember member) {
		member.setMediator(this);
        this.chatMembers.add(member);
	}

	@Override
	public void removeChatMember(IChatMember member) {
		member.setMediator();
		this.chatMembers.remove(member);	
	}
	
	private boolean isBot(IChatMember member) {
	    return member instanceof Bot;
	}
	    
	 private void addBot(String controlWord) {
	    if (controlWord == null) {
	    	return;
	    }
	    	
		// IF THE WORD IS MORE THAN 20 CHARACTERS DON'T ADD BOT;
		if (controlWord.length() > 20) {
			return;
		} 
	
		IFactory factory = new MemberFactory();
		IChatMember bot = factory.getMember(MemberTypes.bot);
		bot.setControlWord(controlWord);
		this.addChatMember(bot);
	}

	@Override
	public void sendMessage(String message, IChatMember member) {

	}

}
