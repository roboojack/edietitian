#!/bin/bash

# author: Robert Jackson
# 
# This is a little script to build and run the edietitian webapp 
# using maven. 
#
#

projectHome=`dirname $0`
user=`whoami`
MVN=/home/$user/Downloads/apache-maven-3.0.3/bin/mvn # set mvn location
#JAVA_HOME=/usr/lib/jvm/java-1.6.0-sun

JETTYPID=`ps -ef | grep 'jetty' | grep -v grep | awk '{print $2}'`	
							 # get the PID of the webserver
kill $JETTYPID						 # kill the webserver if running

echo $MVN						 # peek at location
echo `pwd`						 # peek at present working dir

cd $projectHome						 # move into project home
$MVN clean install					 # clean up project and install into maven

							 # sleep in sep process, wake up, then
							 # start the web browser 
$(sleep 12; firefox "http://localhost:8081/edietitian-web/questionnaire.jsp?knowledgebase=edietitian") &

cd $projectHome/edietitian-web				 # move into web subproject
$MVN jetty:run		    				 # run the webserver


