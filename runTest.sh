#!/bin/bash 
echo "starting system test"
echo "starting docker compose project"
export ELASTICURI=http://127.0.0.1
export ELASTICPORT=9200
docker-compose up -d
for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18	
do  
  STATUS=$(curl -s -o /dev/null -w '%{http_code}' http://127.0.0.1:8000/patient/40)
  if [ $STATUS -eq 200 ]; then
    echo "Got 200! starting test requests"
    break
  else
    echo "Got HTTP-Response code $STATUS trying again"
    sleep 10
  fi
  
done
echo "running test requests"
curl -s -o /dev/null http://127.0.0.1:8000/patient/40
curl -s -o /dev/null http://127.0.0.1:8000/patient/41
curl -s -o /dev/null http://127.0.0.1:8000/patient/42
curl -s -o /dev/null http://127.0.0.1:8000/patient/43
curl -s -o /dev/null  http://127.0.0.1:8000/patient/44
curl -s -o /dev/null http://127.0.0.1:8000/patient/4
curl -s -o /dev/null http://127.0.0.1:8000/patient/10
curl -s -o /dev/null http://127.0.0.1:8000/patient/50
curl -s -o /dev/null http://127.0.0.1:8000/patient/1
curl -s -o /dev/null http://127.0.0.1:8000/patient/12
curl -s -o /dev/null http://127.0.0.1:8000/patient/13
curl -s -o /dev/null http://127.0.0.1:8000/patient/14
curl -s -o /dev/null http://127.0.0.1:8000/patient/15
curl -s -o /dev/null http://127.0.0.1:8000/exam/15
curl -s -o /dev/null http://127.0.0.1:8000/exam/4
curl -s -o /dev/null http://127.0.0.1:8000/exam/12
curl -s -o /dev/null http://127.0.0.1:8000/exam/1
curl -s -o /dev/null http://127.0.0.1:8000/exam/2
curl -s -o /dev/null http://127.0.0.1:8000/exam/50
curl -s -o /dev/null http://127.0.0.1:8000/exam/20
curl -s -o /dev/null http://127.0.0.1:8000/exam/21
curl -s -o /dev/null http://127.0.0.1:8000/exam/22
curl -s -o /dev/null http://127.0.0.1:8000/exam/44
cd ElasticTest
echo "starting mvn test project"
mvn clean test 
rc=$?
if [ $rc -ne 0 ] ; then
  echo 'tests failed for further information look int the /target/surefire-reports folder'; exit $rc
fi


