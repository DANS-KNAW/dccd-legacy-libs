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

import java.io.InputStream;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

/**
 * Abstract XMLValidator for XMLBeans and their serialized manifestations. Implementations of this abstract class should
 * present themselves as Singleton in order to make economic use of resources (the internal versionMap is not static!).
 * 
 * @author ecco Apr 8, 2009
 * @param <T>
 *        object that is subject of validation
 */
public abstract class AbstractXMLBeanValidator<T extends XMLBean> extends AbstractValidator
{

    /**
     * Validate the given XMLBean against the schema of its version.
     * 
     * @param bean
     *        the xmlBean to validate
     * @return the result of the validation
     * @throws XMLException
     *         if something goes wrong in the validating process
     * @throws SAXException
     *         if we encounter a fatal {@link org.xml.sax.SAXParseException}
     * @throws SchemaCreationException
     *         if the schema could not be created
     */
    public XMLErrorHandler validate(final T bean) throws XMLException, SAXException, SchemaCreationException
    {
        final InputStream xmlStream = bean.asXMLInputStream(0);
        return validate(xmlStream, bean.getVersion());
    }

    /**
     * Validate the given XMLBean against the schema of its version and report to the given handler.
     * 
     * @param handler
     *        receives notification of {@link org.xml.sax.SAXParseException}s
     * @param bean
     *        the XMLBean to validate
     * @throws XMLException
     *         if something goes wrong in the validating process
     * @throws SAXException
     *         if we encounter a fatal {@link org.xml.sax.SAXParseException}
     * @throws SchemaCreationException
     *         if the schema could not be created
     */
    public void validate(final ErrorHandler handler, final T bean) throws XMLException, SAXException, SchemaCreationException
    {
        final InputStream xmlStream = bean.asXMLInputStream(0);
        validate(handler, xmlStream, bean.getVersion());
    }

}
