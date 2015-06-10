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
package nl.knaw.dans.common.lang.os;

import java.io.File;
import java.io.IOException;

public class LinuxOsStrategy implements OsStrategy
{

    @Override
    public int setAllRWX(File file, Appendable out, Appendable err) throws IOException
    {
        String cmd = "chmod a=rwx " + file.getPath();
        return OS.execAndWait(cmd, out, err);
    }

    @Override
    public int setAllRWX(String filename, Appendable out, Appendable err) throws IOException
    {
        String cmd = "chmod a=rwx " + filename;
        return OS.execAndWait(cmd, out, err);
    }

}
