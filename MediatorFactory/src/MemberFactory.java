
public class MemberFactory implements IFactory {

	@Override
	public IChatMember getMember(String memberType) {
		
		if (memberType.equals(MemberTypes.user)){
	         return new User();
	      }	else if (memberType.equals(MemberTypes.bot)){
	         return new Bot(); 
	      } else {
	    	 return null;
	      }	     
	}
}
