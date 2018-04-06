import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class DockBeatTest extends TestCase {

    private  ElasticTest tester=new ElasticTest(System.getenv("ELASTICURI"),System.getenv("ELASTICPORT"), "dockbeat*");


    @Before
    public void setup(){
        this.tester=new ElasticTest(System.getenv("ELASTICURI"),System.getenv("ELASTICPORT"), "dockbeat*");
    }

    @Test
    public void testContainer(){
        assertTrue(tester.checkField("container"));
        assertTrue(tester.checkField("container.created"));
        assertTrue(tester.checkField("container.ports"));
        assertTrue(tester.checkField("container.ports.privatePort"));
        assertTrue(tester.checkField("container.ports.publicPort"));
        assertTrue(tester.checkField("container.sizeRootFs"));

    }
    @Test
    public void testCpu(){
        assertTrue(tester.checkField("cpu"));
        assertTrue(tester.checkField("cpu.percpuUsage"));
        assertTrue(tester.checkField("cpu.percpuUsage.cpu0"));
        assertTrue(tester.checkField("cpu.percpuUsage.cpu1"));
        assertTrue(tester.checkField("cpu.percpuUsage.cpu2"));
        assertTrue(tester.checkField("cpu.percpuUsage.cpu3"));
        assertTrue(tester.checkField("cpu.totalUsage"));
        assertTrue(tester.checkField("cpu.usageInKernelmode"));
        assertTrue(tester.checkField("cpu.usageInUsermode"));

    }

    @Test
    public void testMemory(){
        assertTrue(tester.checkField("memory"));
        assertTrue(tester.checkField("memory.failcnt"));
        assertTrue(tester.checkField("memory.limit"));
        assertTrue(tester.checkField("memory.maxUsage"));
        assertTrue(tester.checkField("memory.totalRss"));
        assertTrue(tester.checkField("memory.totalRss_p"));
        assertTrue(tester.checkField("memory.usage"));
        assertTrue(tester.checkField("memory.usage_p"));
    }

    @Test
    public void testNet(){
        assertTrue(tester.checkField("net"));
        assertTrue(tester.checkField("net.rxBytes_ps"));
        assertTrue(tester.checkField("net.rxDropped_ps"));
        assertTrue(tester.checkField("net.rxErrors_ps"));
        assertTrue(tester.checkField("net.rxPackets_ps"));
        assertTrue(tester.checkField("net.txBytes_ps"));
        assertTrue(tester.checkField("net.txDropped_ps"));
        assertTrue(tester.checkField("net.txErrors_ps"));
        assertTrue(tester.checkField("net.txPackets_ps"));
        
    }
}
