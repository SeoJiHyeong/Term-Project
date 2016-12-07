import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class converterTest
{
	@Test
	public void testNew_check_grammar() {
        converter c = new converter();
        String[] a = {"./testData/test.md"};
        assertTrue(c.new_check_grammar(a));
        
        String[] b = {"./testData/test.md","-f","-o","tt"};
        assertTrue(c.new_check_grammar(b));
        String[] b1 = {"./testData/test.md","-o","tt","-f"};
        assertTrue(c.new_check_grammar(b1));
        String[] b2 = {"./testData/test.md","-o","tt","-f","./testData/test2.md","-o","tt","-p"};
        assertTrue(c.new_check_grammar(b2));
        String[] c2 = {"./testData/test.md","-p","-o","tt"};
        assertTrue(c.new_check_grammar(c2));
        String[] c1 = {"./testData/test.md","-o","tt","-p"};
        assertTrue(c.new_check_grammar(c1));
        String[] d = {"./testData/test.md","-s","-o","tt"};
        assertTrue(c.new_check_grammar(d));
        String[] d1 = {"./testData/test.md","-o","tt","-s"};
        assertTrue(c.new_check_grammar(d1));
        String[] o = {"./testData/test.md","-o","tt"};
        assertTrue(c.new_check_grammar(o));
        String[] e = {"-h"};
        assertTrue(c.new_check_grammar(e));
        String[] f = {"--help"};
        assertTrue(c.new_check_grammar(f));
        String[] f1 = {};
        assertTrue(c.new_check_grammar(f1));
	}
    
    @Test
    public void testNew_check_grammar2() {
        converter c = new converter();
        String[] a = {"./testData/test.m"};
        assertTrue(!c.new_check_grammar(a));
        String[] a1 = {"./testData/test3.md"};
        assertTrue(!c.new_check_grammar(a1));
        String[] b = {"./testData/test.md","-l","-o","tt"};
        assertTrue(!c.new_check_grammar(b));
        String[] b1 = {"./testData/test.md","-o","tt","-q"};
        assertTrue(!c.new_check_grammar(b1));
        String[] c2 = {"./testData/test.md","-p","-q","tt"};
        assertTrue(!c.new_check_grammar(c2));
        String[] c1 = {"./testData/test.md","-q","tt","-p"};
        assertTrue(!c.new_check_grammar(c1));
        
        String[] d = {"./testData/test.md","-s","-o","tt","qwe"};
        assertTrue(!c.new_check_grammar(d));
        
        String[] d1 = {"./testData/test.md","-o","-s","tt"};
        assertTrue(!c.new_check_grammar(d1));
        
        String[] d2 = {"./testData/test.md","-o","-s"};
        assertTrue(!c.new_check_grammar(d2));
        
        String[] d3 = {"./testData/test.md","-s","-f","-q","-q"};
        assertTrue(!c.new_check_grammar(d3));
        
        String[] d4 = {"./testData/test.md","222"};
        assertTrue(!c.new_check_grammar(d4));
        
    }

	
}
