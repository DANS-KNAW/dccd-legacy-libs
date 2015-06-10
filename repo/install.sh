#*******************************************************************************
# Copyright 2015 DANS - Data Archiving and Networked Services
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#  
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#*******************************************************************************
# /bin/sh

# Install jars in local maven repo that cannot be found in the public maven repos
# At some point we should have upgraded our lis so we don't need them anymore. 
# 
# mvn install:install-file -Dfile=<path-to-file> -DgroupId=<group-id> -DartifactId=<artifact-id> -Dversion=<version> -Dpackaging=<packaging> -DgeneratePom=true

### DANS modified

# wicket-tree-mod-0.5-SNAPSHOT
mvn install:install-file -Dfile=wicket-tree-mod-0.5-SNAPSHOT.jar -DpomFile=wicket-tree-mod-0.5-SNAPSHOT.pom

### Old existing jars, just difficult to find

# aperture-1.2.0
mvn install:install-file -Dfile=aperture-1.2.0.jar -DpomFile=aperture-1.2.0.pom

# jaxrpc-unknown
mvn install:install-file -Dfile=jaxrpc-unknown.jar -DpomFile=jaxrpc-unknown.pom

# trippi-1.4.1-core-1.0
mvn install:install-file -Dfile=trippi-1.4.1-core-1.0.jar -DpomFile=trippi-1.4.1-core-1.0.pom

# fedora-client-3.0
mvn install:install-file -Dfile=fedora-client-3.0.jar -DpomFile=fedora-client-3.0.pom

# jrdf-0.5.5.4
mvn install:install-file -Dfile=jrdf-0.5.5.4.jar -DpomFile=jrdf-0.5.5.4.pom

# openrdf-sesame-onejar-2.2.1
mvn install:install-file -Dfile=openrdf-sesame-onejar-2.2.1.jar -DpomFile=openrdf-sesame-onejar-2.2.1.pom

# rdf2go.api-4.6.2
mvn install:install-file -Dfile=rdf2go.api-4.6.2.jar -DpomFile=rdf2go.api-4.6.2.pom

