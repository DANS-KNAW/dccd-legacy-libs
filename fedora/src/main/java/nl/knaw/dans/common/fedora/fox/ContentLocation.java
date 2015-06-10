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

public class ContentLocation
{
    public enum Type
    {
        // @formatter:off
        INTERNAL_ID, URL
        // @formatter:on
    }

    private Type type;
    private URI ref;

    protected ContentLocation()
    {
    }

    public ContentLocation(Type type, URI ref)
    {
        this.type = type;
        this.ref = ref;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public URI getRef()
    {
        return ref;
    }

    public void setRef(URI ref)
    {
        this.ref = ref;
    }

}
