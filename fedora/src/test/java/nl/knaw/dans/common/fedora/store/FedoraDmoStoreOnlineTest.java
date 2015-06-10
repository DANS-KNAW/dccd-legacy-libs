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

import java.util.List;

import nl.knaw.dans.common.fedora.Fedora;
import nl.knaw.dans.common.lang.repo.DmoStoreId;
import nl.knaw.dans.common.lang.repo.UnitMetadata;
import nl.knaw.dans.common.lang.test.Tester;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class FedoraDmoStoreOnlineTest
{

    private static FedoraDmoStore STORE;

    @BeforeClass
    public static void beforeClass()
    {
        Fedora fedora = new Fedora(Tester.getString("fedora.base.url"), Tester.getString("fedora.admin.username"), Tester.getString("fedora.admin.userpass"));
        STORE = new FedoraDmoStore("test", fedora);//, null);
    }

    @Ignore
    @Test
    public void getUnitMetadata() throws Exception
    {
        List<UnitMetadata> umdList = STORE.getUnitMetadata(new DmoStoreId("easy-jumpoff:41"));
        for (UnitMetadata umd : umdList)
        {
            System.err.println(umd.getLabel() + " " + umd.getLocation());
        }
    }

}
