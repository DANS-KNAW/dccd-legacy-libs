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
package nl.knaw.dans.common.lang.repo;

import java.io.File;
import java.io.IOException;

public interface BinaryUnit extends Unit
{

    public enum UnitControlGroup
    {
        ExternallyReferencedContent, ManagedContent, RedirectedContent, InlineXML
    }

    // Fedora cannot handle mimetype "undefined"
    // String MIMETYPE_UNDEFINED = "undefined";
    String MIMETYPE_UNDEFINED = "application/octet-stream";

    UnitControlGroup getUnitControlGroup();

    void setUnitControlGroup(UnitControlGroup unitControlGroup);

    boolean hasFile();

    boolean hasBinaryContent();

    File getFile();

    void setFile(File file) throws IOException;

    void setFileContent(byte[] bytes, String label, String mimeType) throws IOException;

    /**
     * Set the given byte array as inline content. Careful! Only works on ingest! Not on update.
     * 
     * @param bytes
     *        the byte array to be stored as managed content  
     * @param label
     *        the label for the unit
     * @param mimeType
     *        the mime type of the content
     */
    void setBinaryContent(byte[] bytes, String label, String mimeType);

    /**
     * The binary content as set by {@link #setBinaryContent(byte[], String, String)}. Always returns
     * <code>null</code> after an object is retrieved from store.
     * 
     * @return The binary content as set by setBinaryContent, <code>null</code> after retrieval of an
     *         object
     */
    byte[] getBinaryContent();

    /**
     * Prepare for storage, like saving any content of this BinaryUnit to file.
     * 
     * @see #setFileContent(byte[], String, String)
     * @throws IOException
     *         if preparing could not be done
     */
    void prepareForStorage() throws IOException;

    /**
     * Releases any system resources associated with this Unit.
     */
    void close();

    String getMimeType();

    long getFileSize();

    String getLocation();

    void setLocation(String location);

}
