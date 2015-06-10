/*******************************************************************************
 * Copyright 2015 DANS - Data Archiving and Networked Services
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package nl.knaw.dans.common.fedora.fox;

import nl.knaw.dans.common.lang.repo.relations.OntologyNamespace;

/**
 * The Fedora RDF namespace.
 * 
 * <pre>
 * Namespace URI    : info:fedora/
 * Preferred Prefix : fedora
 * </pre>
 * 
 * @see <a
 *      href="http://info-uri.info/registry/OAIHandler?verb=GetRecord&metadataPrefix=reg&identifier=info:fedora/">
 *      "info" URI Scheme Registry page</a>
 * @author Chris Wilper
 */
public class FedoraNamespace extends OntologyNamespace
{

    private static final long serialVersionUID = 1L;

    public FedoraNamespace()
    {

        uri = "info:fedora/";
        prefix = "fedora";
    }

}
