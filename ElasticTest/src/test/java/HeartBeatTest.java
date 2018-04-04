import junit.framework.TestCase;
import org.junit.Test;

public class HeartBeatTest extends TestCase {
    private  ElasticTest tester=new ElasticTest(System.getenv("ELASTICURI"),System.getenv("ELASTICPORT"), "vdc*");

    @Test
    public void testHeartBeat(){

    }
}
