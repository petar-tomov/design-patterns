
public class MessageLib {
	
	private String message;
	private String separator;
	
	private int indexSeparator;
	
	public String firstWord;
	public String nextWord;
	
	public MessageLib(String msg, String sep) {
		this.message = msg;
		this.separator = sep;
		
		if (message != null) {
			advance();
		}
	}
	
	private void getFirstWord() {    	
    	// CHECK IF THERE IS SPACE AT THE BEGINNING;
		
    	if (indexSeparator > 0) {
    		firstWord = message.substring(0, indexSeparator);  
    		return;
    	}
    	
    	firstWord = message;
    }
    
    // GET NEXT (LAST) WORD FROM START TO END;
    private void getNextWord() {    	
    	if (indexSeparator > 0) {
        	nextWord = message.substring(indexSeparator + 1, message.length());
    	}
    }
    
    private void getIndex() {
    	indexSeparator = message.indexOf(separator);
    }
    
	private void advance() {
		getIndex();
		getFirstWord();
		getNextWord();
	}
}
