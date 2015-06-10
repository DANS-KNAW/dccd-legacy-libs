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

import nl.knaw.dans.common.lang.RepositoryException;
import nl.knaw.dans.common.lang.test.Tester;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepositoryAccessorOnlineTest extends AbstractRepositoryOnlineTest
{

    private static RepositoryAccessor repositoryAccessor;

    private static final Logger logger = LoggerFactory.getLogger(RepositoryAccessorOnlineTest.class);

    private boolean verbose = Tester.isVerbose();

    @BeforeClass
    public static void beforeClass() throws RepositoryException
    {
        repositoryAccessor = new RepositoryAccessor(getRepository());
    }

    @Test
    public void describeRepository() throws RepositoryException
    {
        String desc = repositoryAccessor.describeRepository().toString();
        if (verbose)
            logger.debug(desc + "\n");
    }

}
