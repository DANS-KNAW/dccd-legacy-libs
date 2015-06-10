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
package nl.knaw.dans.common.lang.repo.relations;

public class RelsConstants
{
    public static final DansOntologyNamespace DANS_NS = new DansOntologyNamespace();

    public static final String RDF_LITERAL = "http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral";

    public static final String OAI_ITEM_ID = "http://www.openarchives.org/OAI/2.0/itemID";

    public static final String OAI_SET_SPEC = "http://www.openarchives.org/OAI/2.0/setSpec";

    public static final String OAI_SET_NAME = "http://www.openarchives.org/OAI/2.0/setName";

    public static final String FEDORA_URI = "info:fedora/";

    public static final String FM_HAS_MODEL = "info:fedora/fedora-system:def/model#hasModel";

    public static final String RELS_EXT_IS_MEMBER_OF = "info:fedora/fedora-system:def/relations-external#isMemberOf";

    public static String getObjectURI(String storeId)
    {
        if (storeId.startsWith(FEDORA_URI))
        {
            return storeId;
        }
        return FEDORA_URI + storeId;
    }

    public static String stripFedoraUri(Object object)
    {
        if (object == null)
        {
            return null;
        }
        String objectURI = object.toString();
        if (!objectURI.startsWith(FEDORA_URI))
        {
            return objectURI;
        }
        return objectURI.substring(FEDORA_URI.length());
    }

}
