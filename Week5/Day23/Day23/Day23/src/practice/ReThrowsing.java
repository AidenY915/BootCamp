package practice;

public class ReThrowsing {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			throw new RuntimeException("1차 던짐");
		}catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			try {
				throw new Exception("다시 던짐");
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
