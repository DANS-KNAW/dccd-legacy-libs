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

import java.net.URI;

import fedora.common.Constants;

public final class FoxConstants
{

    /**
     * The xml-mimetype.
     */
    public static final String MIMETYPE_XML = "text/xml";

    public static final String STREAM_ID_EXT = "RELS-EXT";

    public static final String STREAM_ID_INT = "RELS-INT";

    public static final String LABEL = "RDF Statements about this object";

    public static final URI RELS_EXT_FORMAT_URI_EXT = URI.create(Constants.RELS_EXT1_0.uri);

    public static final URI RELST_INT_FORMAT_URI_INT = URI.create(Constants.RELS_INT1_0.uri);

    public static FedoraModelOntology MODEL_ONTOLOGY = new FedoraModelOntology();

    public static FedoraNamespace FEDORA_NAMESPACE = new FedoraNamespace();

    private FoxConstants()
    {

    }
}
