
public class MainChat {

	public static void main(String[] args) {

		IMessageMediator mediator = new ChatMessageMediator();
		
		IFactory factory = new MemberFactory();
		
		IChatMember firstUser = factory.getMember(MemberTypes.user);
		IChatMember secondUser = factory.getMember(MemberTypes.user);
		IChatMember thirdUser = factory.getMember(MemberTypes.user);
		
		firstUser.setName("Ed");
		secondUser.setName("Edd");
		thirdUser.setName("Eddy");
		
		mediator.addChatMember(firstUser);
		mediator.addChatMember(secondUser);
		mediator.addChatMember(thirdUser);
		
		thirdUser.send("Rock Paper Scissors shoot");
		secondUser.send("addBot cat"); 
		secondUser.send("addBot fuck");
		thirdUser.send("paper");
		secondUser.send("rock"); 
		firstUser.send("cat");
		
		// THIS WON'T SHOW UP
		firstUser.send("Hello");
		
		secondUser.send("Where did Ed go?");
		thirdUser.send("fuck");
		
		secondUser.send("Well, I guess I'm the only one here.");
	}

}
