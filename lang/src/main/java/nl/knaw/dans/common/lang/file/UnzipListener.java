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
import java.util.List;

public interface UnzipListener
{

    void onUnzipStarted(long totalBytes);

    /* a two way upadte:
     * 1. Send an unzip progress update to the implementor via the parameters
     * 2. Returns to the unzipper class if the process should continue
     * @Returns true for continuing the unzipping process and false for stopping it
     */
    boolean onUnzipUpdate(long bytesUnzipped, long total);

    void onUnzipComplete(List<File> files, boolean canceled);
}
