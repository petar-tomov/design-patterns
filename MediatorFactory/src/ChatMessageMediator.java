import java.util.ArrayList;
import java.util.List;

public class ChatMessageMediator implements IMessageMediator {

	private List<IChatMember> chatMembers;
	
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
	    if(controlWord == null)
	    	return;
	    
		if(controlWord.length() < 1 || controlWord.length() > 20 ) 
			return;

		IFactory factory = new MemberFactory();
		IChatMember bot = factory.getMember(MemberTypes.bot);
		bot.setControlWord(controlWord);
			
		this.addChatMember(bot);
	}

	@Override
	public void sendMessage(String message, IChatMember sender) {
		
		MessageLib storage = new MessageLib(message, " ");
		
		for (IChatMember cm : this.chatMembers) {
			if (isBot(cm)) {
				if (!cm.isMessageValid(message, sender)) {
					// IF MESSAGE IS FORBIDDEN = BREAK; 
					break;
				}
			}
			else if (!isBot(sender) && storage.firstWord.equals("addBot")) {
				addBot(storage.nextWord); // nextWord = forbidden word;
				break;
			}
			else {
				// SENDER SHOULD NOT RECEIVE HIS OWN MESSAGE;
				if (cm != sender) {
					cm.receive(message);
				}
			}
		}
	}

}
