#!/bin/bash 
echo "starting system test"
echo "starting docker compose project"
docker-compose up -d
for i in 1 2 3 4 5 6 
do  
  STATUS=$(curl -s -o /dev/null -w '%{http_code}' http://127.0.0.1:8000/patient/40)
  if [ $STATUS -eq 200 ]; then
    echo "Got 200! starting app"
    break
  else
    echo "Got $STATUS trying again"
  fi
  echo "$i"
  wait 10
done
echo "starting app"
cd ElasticTest
mvn clean install --log-file log.txt
rc=$?
if [[ $rc -ne 0 ]] ; then
  echo 'could not perform tests'; exit $rc
fi


