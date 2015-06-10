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
package nl.knaw.dans.common.wicket.rest;

import java.io.IOException;
import java.io.InputStream;

import nl.knaw.dans.common.lang.repo.types.CommonFileItem;

import org.apache.wicket.AbortException;
import org.apache.wicket.PageParameters;
import org.apache.wicket.protocol.http.WebResponse;

public abstract class RESTdisseminationPage extends RESTpage
{

    public RESTdisseminationPage(PageParameters parameters)
    {
        super(parameters);
    }

    protected abstract void disseminate();

    @Override
    public int getLevel()
    {
        return 0;
    }

    @Override
    protected void cascadeToChild()
    {
        throw new IllegalStateException("A Disseminator is not supposed to cascade.");
    }

    protected void writeXml(String filename, byte[] xml) throws IOException
    {
        String name = filename == null ? "no-name.xml" : filename.replaceAll(" ", "_");

        WebResponse response = getWebRequestCycle().getWebResponse();
        response.setContentType("text/xml");
        response.setHeader("Content-Length", "" + xml.length);
        response.setHeader("Content-Disposition", "filename=" + name);
        response.getOutputStream().write(xml);
        throw new AbortException();

    }

    protected void write(CommonFileItem fileDmo, InputStream inStream)
    {
        write(fileDmo.getLabel(), fileDmo.getMimeType(), fileDmo.getSize(), inStream);
    }

    protected void write(String filename, String mimeType, long length, InputStream inStream)
    {
        String name = filename == null ? "no-name" : filename.replaceAll(" ", "_");

        WebResponse response = getWebRequestCycle().getWebResponse();
        response.setContentType(mimeType);
        response.setHeader("Content-Length", "" + length);
        response.setHeader("Content-Disposition", "filename=" + name);
        response.write(inStream);
        throw new AbortException();
    }

}
