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
package nl.knaw.dans.common.lang.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

public class ZipItem
{

    private String virtualPath;
    private URL streamUrl;
    private File file;
    private String systemPath;

    public ZipItem(String virtualPath)
    {
        setVirtualPath(virtualPath);
    }

    public ZipItem(String virtualPath, File file)
    {
        setVirtualPath(virtualPath);
        this.file = file;
    }

    public ZipItem(String virtualPath, URL url)
    {
        setVirtualPath(virtualPath);
        this.streamUrl = url;
    }

    public ZipItem(String virtualPath, String systemPath)
    {
        setVirtualPath(virtualPath);
        this.systemPath = systemPath;
    }

    /**
     * Set the path this item will get in the zip.
     * 
     * @param virtualPath
     */
    public void setVirtualPath(String virtualPath)
    {
        if (StringUtils.isBlank(virtualPath))
        {
            throw new IllegalArgumentException("The virtual path cannot be null and cannot be empty.");
        }
        this.virtualPath = virtualPath;
    }

    public String getVirtualPath()
    {
        return virtualPath;
    }

    public void setStreamUrl(URL streamUrl)
    {
        this.streamUrl = streamUrl;
    }

    public URL getStreamUrl()
    {
        return streamUrl;
    }

    public boolean hasStreamUrl()
    {
        return streamUrl != null;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public File getFile()
    {
        return file;
    }

    public boolean hasFile()
    {
        return file != null;
    }

    public String getSystemPath()
    {
        return systemPath;
    }

    public void setSystemPath(String systemPath)
    {
        this.systemPath = systemPath;
    }

    public boolean hasSystemPath()
    {
        return systemPath != null;
    }

    public boolean hasInputStream()
    {
        return hasStreamUrl() || hasFile() || hasSystemPath();
    }

    public InputStream getInputStream() throws IOException
    {
        if (hasStreamUrl())
        {
            return streamUrl.openStream();
        }
        else if (hasFile())
        {
            return new FileInputStream(file);
        }
        else if (hasSystemPath())
        {
            return new FileInputStream(systemPath);
        }
        else
        {
            throw new IOException("No file, url or systemPath specified for virtual path " + getVirtualPath());
        }
    }
}
