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
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nl.knaw.dans.common.lang.repo.DmoStoreId;

public class SidListFile
{
    public static List<DmoStoreId> readSidList(File sidListFile) throws IOException
    {
        List<DmoStoreId> result = new ArrayList<DmoStoreId>();
        RandomAccessFile raf = null;
        try
        {
            raf = new RandomAccessFile(sidListFile, "r");
            String s;
            while ((s = raf.readLine()) != null)
            {
                result.add(new DmoStoreId(s));
            }
        }
        finally
        {
            if (raf != null)
            {
                raf.close();
            }
        }
        return result;
    }

    public static void writeSidList(File sidListFile, Collection<DmoStoreId> sidList) throws IOException
    {
        RandomAccessFile raf = null;
        try
        {
            raf = new RandomAccessFile(sidListFile, "rw");
            for (DmoStoreId sid : sidList)
            {
                raf.writeBytes(sid + "\r\n");
            }
        }
        finally
        {
            if (raf != null)
            {
                raf.close();
            }
        }
    }

}
