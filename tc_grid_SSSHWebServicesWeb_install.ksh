#!/bin/ksh
#############################################################################
#
# Template for WAR deployment to Tomcat Application Server
#
# Fill in the variables listed below.
#
# Notes:
#
#     * This script will deploy a new war or replace an existing one.
#       If you are replacing an existing application this script will
#       ******CAUSE AN OUTAGE****** by stopping and removing the existing
#       application.  
#
#     * Be sure to include the directory that you have deployed
#       your war file to as the WAR_DIR variable.
#
#     * This script assumes you have already created your application
#       server. If the server does not exist, this script will exit.
#
#     * For backout abilities this script will backup the existing 
#       war file in /tmp
#
#     * The war file name needs to be same if the application is already
#       deployed to Tomcat.
#
# $Header:  $
# $Source:  $
# $Revision:  $
# $Author:  $
# $Log:  $
##
#
#############################################################################
ACTION_VAR=CREATE                           
WAR_DIR=/var/opt/tomcat/sh/java/wars 	    
WAR_FILENAME=SSSHWebServicesWeb.war                 
APPLICATION_SERVER=ssshSFIServices

##############################################################################
#  DO NOT EDIT BELOW THIS LINE............DO NOT EDIT BELOW THIS LINE........
##############################################################################


TOMCATDIR=${TOMCATDIR_:-/opt/isv/tomcat};export TOMCATDIR

if [ $ACTION_VAR = "CREATE" ]
then
  SCRIPT_NM="tc6_installApp.ksh"
fi

if [ $ACTION_VAR = "DELETE" ]
then
  SCRIPT_NM="tc6_deleteApp.ksh"
fi

  /opt/hd/aa/bin/$SCRIPT_NM $WAR_DIR/$WAR_FILENAME $APPLICATION_SERVER


exit $?

#---------------
# End of Script
#---------------
