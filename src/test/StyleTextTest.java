import org.junit.Test ;
import static org.junit.Assert.* ;
import md.*;
public class StyleTextTest
{
	@Test
	public void testNotice1() {
        StyleText s = new StyleText("em");
        assertEquals(s.notifyToken(),"<em>");
	}

    @Test
    public void testNotice2() {
        StyleText s = new StyleText("/em");
        assertEquals(s.notifyToken(),"</em>");
    }
    
    @Test
    public void testNotice3() {
        StyleText s = new StyleText("strong");
        assertEquals(s.notifyToken(),"<strong>");
    }
    
    @Test
    public void testNotice4() {
        StyleText s = new StyleText("/strong");
        assertEquals(s.notifyToken(),"</strong>");
    }
    
    @Test
    public void testNotice5() {
        StyleText s = new StyleText("image");
        assertEquals(s.notifyToken(),"image");
    }
    
    @Test
    public void testNotice6() {
        StyleText s = new StyleText("/image");
        assertEquals(s.notifyToken(),"/image");
    }
    
    @Test
    public void testNotice7() {
        StyleText s = new StyleText("link");
        assertEquals(s.notifyToken(),"link");
    }
    
    @Test
    public void testNotice8() {
        StyleText s = new StyleText("/link");
        assertEquals(s.notifyToken(),"/link");
    }
    
    @Test
    public void testNotice9() {
        StyleText s = new StyleText("ddddd");
        assertEquals("ddddd",s.notifyToken());
        
    }
    
    @Test
    public void testNotice10() {
        StyleText s = new StyleText("title");
        assertEquals(s.notifyToken(),"title");
    }
    
    @Test
    public void testNotice11() {
        StyleText s = new StyleText("/title");
        assertEquals(s.notifyToken(),"/title");
    }
    
    @Test
    public void testNotice12() {
        StyleText s = new StyleText("code");
        assertEquals(s.notifyToken(),"<code>");
    }
    
    @Test
    public void testNotice13() {
        StyleText s = new StyleText("/code");
        assertEquals(s.notifyToken(),"</title>");
    }
}
