import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
import org.w3c.tidy.Tidy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class converterTest
{
	@Test
	public void testNew_check_grammar() {
        converter c = new converter();
        String[] a = {"./src/test/testData/test.md"};
        assertTrue(c.new_check_grammar(a));
        
        String[] b = {"./src/test/testData/test.md","-f","-o","tt"};
        assertTrue(c.new_check_grammar(b));
        String[] b1 = {"./src/test/testData/test.md","-o","tt","-f"};
        assertTrue(c.new_check_grammar(b1));
        String[] b2 = {"./src/test/testData/test.md","-o","tt","-f","./testData/test2.md","-o","tt","-p"};
        assertTrue(c.new_check_grammar(b2));
        String[] c2 = {"./src/test/testData/test.md","-p","-o","tt"};
        assertTrue(c.new_check_grammar(c2));
        String[] c1 = {"./src/test/testData/test.md","-o","tt","-p"};
        assertTrue(c.new_check_grammar(c1));
        String[] d = {"./src/test/testData/test.md","-s","-o","tt"};
        assertTrue(c.new_check_grammar(d));
        String[] d1 = {"./src/test/testData/test.md","-o","tt","-s"};
        assertTrue(c.new_check_grammar(d1));
        String[] o = {"./src/test/testData/test.md","-o","tt"};
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
        String[] a = {"./src/test/testData/test.m"};
        assertTrue(!c.new_check_grammar(a));
        String[] a1 = {"./src/test/testData/test3.md"};
        assertTrue(!c.new_check_grammar(a1));
        String[] b = {"./src/test/testData/test.md","-l","-o","tt"};
        assertTrue(!c.new_check_grammar(b));
        String[] b1 = {"./src/test/testData/test.md","-o","tt","-q"};
        assertTrue(!c.new_check_grammar(b1));
        String[] c2 = {"./src/test/testData/test.md","-p","-q","tt"};
        assertTrue(!c.new_check_grammar(c2));
        String[] c1 = {"./src/test/testData/test.md","-q","tt","-p"};
        assertTrue(!c.new_check_grammar(c1));
        
        String[] d = {"./src/test/testData/test.md","-s","-o","tt","qwe"};
        assertTrue(!c.new_check_grammar(d));
        
        String[] d1 = {"./src/test/testData/test.md","-o","-s","tt"};
        assertTrue(!c.new_check_grammar(d1));
        
        String[] d2 = {"./src/test/testData/test.md","-o","-s"};
        assertTrue(!c.new_check_grammar(d2));
        
        String[] d3 = {"./src/test/testData/test.md","-s","-f","-q","-q"};
        assertTrue(!c.new_check_grammar(d3));
        
        String[] d4 = {"./src/test/testData/test.md","222"};
        assertTrue(!c.new_check_grammar(d4));
        
    }
    
    @Test
    public void testJtidy1(){
        converter c = new converter();
        String tmp = "<html><head></head><body></body></html>";
        assertTrue(c.jtidy_check(tmp));
        
        
    }
    
    @Test
    public void testJtidy2(){
        converter c = new converter();
        String tmp = "<12html><4head></h5ead><b6ody></html>";
        assertTrue(!c.jtidy_check(tmp));
    }
    
    @Test
    public void testMain(){
        try{
            converter c = new converter();
            String[] ss = {"./src/test/testData/test.md"};
            c.main(ss);
            BufferedReader br = new BufferedReader(new FileReader("result.html"));
            assertEquals("<html><h1>An h1 header</h1></html>",br.readLine());
        }catch(IOException e){
            System.out.println("File not found");
        }
      
        
    }
    

	
}
