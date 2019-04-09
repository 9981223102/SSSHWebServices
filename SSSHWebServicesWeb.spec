############ DO NOT MODIFY THIS SECTION ############
%define RPM_BUILD_ROOT $(pwd)
%define svn_repo %(echo "$REPO")
%define svn_project %(echo "$PROJECT")
%define svn_tagname %(echo "$TAGNAME")
%define date %(date +'%a %b %d %G')
%define sum %(echo "Created from SVN Project: $REPO/$PROJECT Using tag $TAGNAME")
####################################################

#>>>>>--------------------------------------------------<<<<<#
# RPM package information                                    #
Name: hd-tcgrid-sh-SSSHWebServicesWeb
Version: 2.0
Release: 4
Summary: %{sum}
Group: The Home Depot
#>>>>>--------------------------------------------------<<<<<#



############ DO NOT MODIFY THIS SECTION ############
License: Non-Commercial
BuildRoot: %{_tmppath}/%{name}-%{version}-%{release}
AutoProv: 0
AutoReq: 0
####################################################



#>>>>>--------------------------------------------------<<<<<#
# Add here the RPM package description                       #
%description
This is packaging SSSHWebServicesWeb 
#>>>>>--------------------------------------------------<<<<<#



############ DO NOT MODIFY THIS SECTION ############
%prep
%install
mkdir -p %{buildroot}
export PKG_NAME=%{name}
export OM_BUILD_DIR=/build/Build_"$BUILD_NUMBER"_$PROJECT/$TAG_NAME
####################################################



#>>>>>--------------------------------------------------<<<<<#
# Add here the files to package relative to the Meister      #
# Build Directory ($OM_BUILD_DIR) and the final file name    #
# and location on the runtime environment                    #
# NOTE : - each file to package need to be defined relative  #
#          to $OM_BUILD_DIR                                  #
#        - each final file name and location need to be      #
#          defined relative to %{buildroot}                  #

install -D $OM_BUILD_DIR/SSSHWebServicesWeb.war %{buildroot}/var/opt/tomcat/sh/java/wars/SSSHWebServicesWeb.war
install -D $OM_BUILD_DIR/tc_grid_SSSHWebServicesWeb_install.ksh %{buildroot}/var/opt/tomcat/sh/java/wars/tc_grid_SSSHWebServicesWeb_install.ksh
install -D $OM_BUILD_DIR/tc_grid_SSSHWebServicesWeb_uninstall.ksh %{buildroot}/var/opt/tomcat/sh/java/wars/tc_grid_SSSHWebServicesWeb_uninstall.ksh

#>>>>>--------------------------------------------------<<<<<#



############ DO NOT MODIFY THIS SECTION ############
%build
####################################################



############ DO NOT MODIFY THIS SECTION ############
%files
####################################################



#>>>>>--------------------------------------------------<<<<<#
# Add here attributes to define for each file name deployed  #
# on the runtime environment                                #
%attr(0755,tomcat,tomcat) /var/opt/tomcat/sh/java/wars/SSSHWebServicesWeb.war
%attr(0755,tomcat,tomcat) /var/opt/tomcat/sh/java/wars/tc_grid_SSSHWebServicesWeb_install.ksh
%attr(0755,tomcat,tomcat) /var/opt/tomcat/sh/java/wars/tc_grid_SSSHWebServicesWeb_uninstall.ksh

#>>>>>--------------------------------------------------<<<<<#

%post
/var/opt/tomcat/sh/java/wars/tc_grid_SSSHWebServicesWeb_install.ksh

%preun
/var/opt/tomcat/sh/java/wars/tc_grid_SSSHWebServicesWeb_uninstall.ksh $*

############ DO NOT MODIFY THIS SECTION ############
%clean
####################################################
%changelog

* %{date} - SVN / Changelog Info

SVN Information
==============================
Repository - %{svn_repo}
Project - %{svn_project}
TagName - %{svn_tagname}
