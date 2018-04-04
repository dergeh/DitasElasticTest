import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;


public class RequestMonitorTest extends TestCase{
    private ElasticTest tester=new ElasticTest(System.getenv("ELASTICURI"),System.getenv("ELASTICPORT"), "osrvdc*");

    @Before
    public void setup(){
        this.tester=new ElasticTest(System.getenv("ELASTICURI"),System.getenv("ELASTICPORT"), "osrvdc*");

    }
    @Test
    public void testRemoteAddr(){
         assertTrue(tester.checkField("requestmonitor.remote_addr"));
    }
    @Test
    public void testRequest(){
        assertTrue(tester.checkField("requestmonitor.request"));
    }
    @Test
    public void testRequestTime(){
        assertTrue(tester.checkField("requestmonitor.request_time"));
    }
    @Test
    public void testBodyBytesSent(){
        assertTrue(tester.checkField("requestmonitor.body_bytes_sent"));
    }
    @Test
    public void testTimeLocal(){
        assertTrue(tester.checkField("requestmonitor.time_local"));
    }
    @Test
    public void testUpstreamResponseTime(){
        assertTrue(tester.checkField("requestmonitor.upstream_response_time"));
    }
    @Test
    public void testRequestId(){
        assertTrue(tester.checkField("requestmonitor.request_id"));
    }
    @Test
    public void testStatus(){
        assertTrue(tester.checkField("requestmonitor.status"));
    }
    @Test
    public void testTimestamp(){
        assertTrue(tester.checkField("@timestamp"));
    }
}
