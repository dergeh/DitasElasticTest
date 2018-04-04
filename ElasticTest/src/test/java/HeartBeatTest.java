import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class HeartBeatTest extends TestCase {
    private  ElasticTest tester=new ElasticTest(System.getenv("ELASTICURI"),System.getenv("ELASTICPORT"), "vdc*");


    @Before
    public void setup(){
        this.tester=new ElasticTest(System.getenv("ELASTICURI"),System.getenv("ELASTICPORT"), "vdc*");
    }

    @Test
    public void testInterval(){
        assertTrue(tester.checkField("interval"));
    }

    @Test
    public void testTimestamp(){
        assertTrue(tester.checkField("@timestamp"));
    }
}
