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
package nl.knaw.dans.common.lang;

import java.io.File;

public class FileSystemHomeDirectory implements HomeDirectory
{
    private File homedir;

    public FileSystemHomeDirectory(File homedir)
    {
        this.homedir = homedir;
    }

    @Override
    public String getHome()
    {
        return homedir.getAbsolutePath();
    }

    @Override
    public File getHomeDirectory()
    {
        return homedir;
    }

}
