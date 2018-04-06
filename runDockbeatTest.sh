#!/bin/bash 
echo "starting system test"
echo "starting docker compose project"
export ELASTICURI=http://127.0.0.1
export ELASTICPORT=9200
VDCURI="http://127.0.0.1:8000"
docker-compose up -d
for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18	
do  
  STATUS=$(curl -s -o /dev/null -w '%{http_code}' $VDCURI/patient/40)
  if [ $STATUS -eq 200 ]; then
    echo "Got 200! starting test requests"
    break
  else
    echo "Got HTTP-Response code $STATUS trying again"
    sleep 10
  fi
  
done
echo "running test requests"
curl -s -o /dev/null $VDCURI/patient/40
curl -s -o /dev/null $VDCURI/patient/41
curl -s -o /dev/null $VDCURI/patient/42
curl -s -o /dev/null $VDCURI/patient/43
curl -s -o /dev/null $VDCURI/patient/44
curl -s -o /dev/null $VDCURI/patient/4
curl -s -o /dev/null $VDCURI/patient/10
curl -s -o /dev/null $VDCURI/patient/50
curl -s -o /dev/null $VDCURI/patient/1
curl -s -o /dev/null $VDCURI/patient/12
curl -s -o /dev/null $VDCURI/patient/13
curl -s -o /dev/null $VDCURI/patient/14
curl -s -o /dev/null $VDCURI/patient/15
curl -s -o /dev/null $VDCURI/exam/15
curl -s -o /dev/null $VDCURI/exam/4
curl -s -o /dev/null $VDCURI/exam/12
curl -s -o /dev/null $VDCURI/exam/1
curl -s -o /dev/null $VDCURI/exam/2
curl -s -o /dev/null $VDCURI/exam/50
curl -s -o /dev/null $VDCURI/exam/20
curl -s -o /dev/null $VDCURI/exam/21
curl -s -o /dev/null $VDCURI/exam/22
curl -s -o /dev/null $VDCURI/exam/44
cd ElasticTest
echo "starting mvn test Dockbeat"
mvn clean test -Dtest=DockbeatTest
rc=$?
if [ $rc -ne 0 ] ; then
  echo 'tests failed for further information look int the /target/surefire-reports folder'; exit $rc
fi

