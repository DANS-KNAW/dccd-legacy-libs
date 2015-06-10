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
package nl.knaw.dans.common.lang.mail;

import java.io.File;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.util.ByteArrayDataSource;

/** Immutable object */
public class Attachement
{
    public final String fileName;
    final DataSource dataSource;

    public Attachement(final String fileName, final File file)
    {
        // TODO don't we need a content type?
        dataSource = new FileDataSource(file);
        this.fileName = fileName;
    }

    public Attachement(final String fileName, final String mimeType, final byte[] content)
    {
        dataSource = new ByteArrayDataSource(content, mimeType);
        this.fileName = fileName;
    }
}
