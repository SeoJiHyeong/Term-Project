import org.junit.Test ;
import static org.junit.Assert.* ;

public class SimpleTest
{
    
	@Test
	public void testSimple1() {
		Simple s = new Simple() ;
		assertTrue(s.exec(-1) == 1) ;
	}

	@Test
	public void testSimple2() {
		Simple s = new Simple() ;
		assertTrue(s.exec(1) == 1) ;
	}

}
