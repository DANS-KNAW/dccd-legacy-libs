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
package nl.knaw.dans.common.fedora.store;

import nl.knaw.dans.common.fedora.rdf.FedoraURIReference;
import nl.knaw.dans.common.lang.test.Tester;

import org.junit.Test;

public class FedoraDmoStoreTest
{

    @Test
    public void printQuery()
    {
        if (Tester.isVerbose())
        {
            System.out.println(FedoraDmoStore.createSubordinateQuery(FedoraURIReference.create("easy-dataset:4000")));
            System.out.println(FedoraDmoStore.createJumpoffQuery("bla"));
        }
    }

}
