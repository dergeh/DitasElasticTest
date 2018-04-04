import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class VDCAgentTrafficTest extends TestCase {
   private  ElasticTest tester=new ElasticTest(System.getenv("ELASTICURI"),System.getenv("ELASTICPORT"), "vdc*");
    @Before
    public void setup(){
        this.tester=new ElasticTest(System.getenv("ELASTICURI"),System.getenv("ELASTICPORT"), "vdc*");
    }

    @Test
    public void testComponent(){
        assertTrue(tester.checkField("component"));
    }
    @Test
    public void testBytes(){
        assertTrue(tester.checkField("bytes"));
    }
    @Test
    public void testDate(){
        assertTrue(tester.checkField("date"));
    }
    @Test
    public void testTimestamp(){
        assertTrue(tester.checkField("@timestamp"));
    }
}
