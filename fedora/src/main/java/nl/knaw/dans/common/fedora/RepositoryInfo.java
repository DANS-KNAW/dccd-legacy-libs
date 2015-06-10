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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RepositoryInfo
{
    private final fedora.server.types.gen.RepositoryInfo info;

    public RepositoryInfo(fedora.server.types.gen.RepositoryInfo info)
    {
        this.info = info;
    }

    public String[] getAdminEmailList()
    {
        return info.getAdminEmailList();
    }

    public String getDefaultExportFormat()
    {
        return info.getDefaultExportFormat();
    }

    public String getOAINamespace()
    {
        return info.getOAINamespace();
    }

    public String getRepositoryBaseURL()
    {
        return info.getRepositoryBaseURL();
    }

    public String getRepositoryName()
    {
        return info.getRepositoryName();
    }

    public String getRepositoryPIDNamespace()
    {
        return info.getRepositoryPIDNamespace();
    }

    public String getRepositoryVersion()
    {
        return info.getRepositoryVersion();
    }

    public String[] getRetainPIDs()
    {
        return info.getRetainPIDs();
    }

    public String getSampleAccessURL()
    {
        return info.getSampleAccessURL();
    }

    public String getSampleOAIIdentifier()
    {
        return info.getSampleOAIIdentifier();
    }

    public String getSampleOAIURL()
    {
        return info.getSampleOAIURL();
    }

    public String getSamplePID()
    {
        return info.getSamplePID();
    }

    public String getSampleSearchURL()
    {
        return info.getSampleSearchURL();
    }

    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        for (Method method : this.getClass().getDeclaredMethods())
        {
            if (!"toString".equals(method.getName()))
            {
                try
                {
                    builder.append("\n" + method.getName().substring(3));
                    final Object value = method.invoke(this);
                    if (value == null)
                    {
                        builder.append("=null");
                    }
                    else if (value.getClass().isArray())
                    {
                        builder.append(":");
                        final String[] values = (String[]) value;
                        for (String v : values)
                        {
                            builder.append("\n\t" + v);
                        }
                    }
                    else
                    {
                        builder.append("=" + value);
                    }

                }
                catch (final IllegalArgumentException e)
                {
                    throw new RuntimeException(e);
                }
                catch (final IllegalAccessException e)
                {
                    throw new RuntimeException(e);
                }
                catch (final InvocationTargetException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
        return builder.toString();
    }

}
