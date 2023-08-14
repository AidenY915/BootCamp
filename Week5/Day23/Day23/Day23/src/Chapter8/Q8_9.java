package Chapter8;

class UnsupportedFuctionException extends RuntimeException {
	final private static int ERR_CODE = 100;
	
	
	public UnsupportedFuctionException(String message, int errCode) {
		super("["+errCode+"]"+message);
		// TODO Auto-generated constructor stub
	}
	

	public UnsupportedFuctionException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UnsupportedFuctionException(String message) {
		super(ERR_CODE+message);
		// TODO Auto-generated constructor stub
	}


	public int getErrorCode() {return ERR_CODE;}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	
}

class Q8_9
{
	public static void main(String[] args) throws Exception
	{
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다.",100);
	}
}