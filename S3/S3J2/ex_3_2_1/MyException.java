package ex_3_2_1;

public class MyException  {
	
public MyException() {
	
}
/*Exception thrower
 * a-Exception Catcher
 * b-Exception propagator */

//a-Exception Catcher

/*public void fun(int x) {
	try {
		if (x>30 || x<10) {
			throw new Exception("The value is not in the allowed interval");
		}
			
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
}*/


//b-Exception propagator 


public void UseMyException(int val) throws Exception{
	if (val>30 || val<10) {
		throw new Exception("The value is not in the allowed interval");

}
	
}


}
