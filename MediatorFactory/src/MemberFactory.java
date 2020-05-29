
public class MemberFactory implements IFactory {

	@Override
	public IChatMember getMember(String memberType) {
		
		if (memberType.equals(MemberTypes.bot)){
	         return new Bot();
	      }	
		else if (memberType.equals(MemberTypes.user)){
	         return new User(); 
	      } 
		else {
	    	 return null;
	      }	     
	}
}
