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
package nl.knaw.dans.common.fedora;

import java.rmi.RemoteException;

import nl.knaw.dans.common.jibx.util.Converter;
import nl.knaw.dans.common.lang.RepositoryException;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fedora.server.types.gen.MIMETypedStream;
import fedora.server.types.gen.ObjectMethodsDef;
import fedora.server.types.gen.Property;

public class DisseminationAccessor
{
    private static final Logger logger = LoggerFactory.getLogger(DisseminationAccessor.class);

    private final Repository repository;

    public DisseminationAccessor(Repository repository)
    {
        this.repository = repository;
    }

    public MIMETypedStream getDissemination(String sid, String serviceDefinitionSid, String methodName, Property[] parameters, DateTime asOfDateTime)
            throws RepositoryException
    {
        MIMETypedStream mimeTypedStream = null;
        String asOfDateTimeString = Converter.serializeToXml(asOfDateTime);
        try
        {
            mimeTypedStream = repository.getFedoraAPIA().getDissemination(sid, serviceDefinitionSid, methodName, parameters, asOfDateTimeString);
            if (logger.isDebugEnabled())
            {
                logger.debug("Got dissemination. sid=" + sid + " serviceDefinitionSid=" + serviceDefinitionSid + "methodName=" + methodName);
            }
        }
        catch (RemoteException e)
        {
            String msg = "Unable to get datastream dissemination: ";
            logger.debug(msg, e);
            Repository.mapRemoteException(msg, e);
        }
        return mimeTypedStream;
    }

    public ObjectMethodsDef[] listMethods(String sid, DateTime asOfDateTime) throws RepositoryException
    {
        ObjectMethodsDef[] methodDefs = null;
        String asOfDateTimeString = Converter.serializeToXml(asOfDateTime);
        try
        {
            methodDefs = repository.getFedoraAPIA().listMethods(sid, asOfDateTimeString);
            if (logger.isDebugEnabled())
            {
                logger.debug("Got object method definitions. sid=" + sid);
            }
        }
        catch (RemoteException e)
        {
            String msg = "Unable to get object method definitions: ";
            logger.debug(msg, e);
            Repository.mapRemoteException(msg, e);
        }
        return methodDefs;
    }

}
