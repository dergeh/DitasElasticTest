# DitasElasticTest
this is a mvn project to test the tub-dummy-example https://github.com/DITAS-Project/tub-dummy-example

to run the script you need to copy the test project into the tub-dummy-example folder and execute runTest.sh

the test results will be dumped into /target/surefire-reports 

## Testing specific Modules

to test specific modules you need to change the runTest.sh in line 45 add one of the following options at the end of the line

* -Dtest=HeartbeatTest 
* -Dtest=RequestMonitorTest 
* -Dtest=VDCAgentTrafficTest 
* -Dtest=DockbeatTest 



