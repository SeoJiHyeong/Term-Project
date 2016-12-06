import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
import java.util.ArrayList;
public class DocumentTest
{
    
	@Test
	public void testAddDocument() {
        Document d = new Document();
        String tmp = "test";
        ArrayList<String> test = new ArrayList();
        d.addDocument(tmp);
        test = d.getDocument();
        assertEquals(tmp,test.get(0));
        
	}

	

}
