#!/bin/sh

export JAVA_HOME=/usr/local/webserver/jdk1.7.0_55/
CURRENT_PATH=$(pwd)

THE_CLASSPATH=
for i in `ls ./lib/*.jar`
do
  THE_CLASSPATH=${THE_CLASSPATH}:${i}
done
java -Dlog4j.configurationFile=${CURRENT_PATH}/log4j2.xml -classpath ${THE_CLASSPATH} com.send.ons.ProducerTest