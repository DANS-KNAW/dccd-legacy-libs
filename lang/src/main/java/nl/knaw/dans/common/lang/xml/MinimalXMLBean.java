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
package nl.knaw.dans.common.lang.xml;

import java.io.Serializable;

/**
 * Minimal XML bean is an object that can return an XML representation
 * of itself. It is minimal in that sense that is has only the one method
 * that is needed to accomplish that goal. For a richer interface see
 * XMLBean
 * 
 * @see XMLBean 
 * 
 * @author lobo Apr 1, 2010
 */
public interface MinimalXMLBean extends Serializable
{
    /**
     * Serialize this bean to a byte array.
     * 
     * @return bean as byte array
     * @throws XMLSerializationException
     *         if something goes wrong
     */
    byte[] asObjectXML() throws XMLSerializationException;
}
