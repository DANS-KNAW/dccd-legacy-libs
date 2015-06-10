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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.knaw.dans.common.lang.ResourceNotFoundException;
import nl.knaw.dans.common.lang.test.Tester;

import org.junit.Test;

public class ZipUtilTest
{

    @Test
    public void zipFiles() throws Exception
    {
        File testOutput = new File("test-output");
        testOutput.mkdirs();

        File unzipOutput = new File("test-output/unzipped/");
        unzipOutput.mkdirs();

        File unZippedFolder = new File(unzipOutput, "foo/bar/");
        unZippedFolder.delete();

        File unZippedFile = new File(unzipOutput, "test1/Data/Databases/database_preservation.pdf");
        unZippedFile.delete();

        unZippedFolder = new File(unzipOutput, "foo/bar/");
        assertFalse("test preconditions are not met.", unZippedFolder.exists());
        unZippedFile = new File(unzipOutput, "test1/Data/Databases/database_preservation.pdf");
        assertFalse("test preconditions are not met.", unZippedFile.exists());

        // start testing
        File zipFile = new File(testOutput, "zip-test01.zip");
        List<ZipItem> zipItems = new ArrayList<ZipItem>();

        ZipItem zipFolderItem = new ZipItem("foo/bar/");
        zipItems.add(zipFolderItem);

        ZipItem zipFileItem = new ZipItem("test1/Data/Databases/database_preservation.pdf", Tester
                .getFile("test-files/zipFile/test1/Data/Databases/database_preservation.pdf"));

        zipItems.add(zipFileItem);

        ZipUtil.zipFiles(zipFile, zipItems);

        //

        UnzipUtil.unzip(zipFile, "test-output/unzipped");
        unZippedFolder = new File(unzipOutput, "foo/bar/");
        assertTrue(unZippedFolder.exists());
        unZippedFile = new File(unzipOutput, "test1/Data/Databases/database_preservation.pdf");
        assertTrue(unZippedFile.exists());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionStates() throws IOException, ResourceNotFoundException
    {
        File testOutput = new File("test-output");
        testOutput.mkdirs();

        File zipFile = new File(testOutput, "zip-test02.zip");
        List<ZipItem> zipItems = new ArrayList<ZipItem>();

        ZipItem zipFileItem = new ZipItem("test1/Data/Databases/database_preservation.pdf", Tester
                .getFile("test-files/zipFile/test1/Data/Databases/database_preservation.pdf"));

        zipItems.add(zipFileItem);

        ZipItem zipFolderItem = new ZipItem("", "bla.txt");
        zipItems.add(zipFolderItem);

        ZipUtil.zipFiles(zipFile, zipItems);
    }

}
