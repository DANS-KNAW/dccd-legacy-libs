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

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fedora.server.types.gen.ComparisonOperator;
import fedora.server.types.gen.Condition;
import fedora.server.types.gen.FieldSearchQuery;
import fedora.server.types.gen.FieldSearchResult;
import fedora.server.types.gen.ObjectFields;

public class ObjectAccessorOnlineTest extends AbstractRepositoryOnlineTest
{

    private static final Logger logger = LoggerFactory.getLogger(ObjectAccessorOnlineTest.class);

    private static ObjectAccessor accessor;

    @BeforeClass
    public static void beforeClass() throws RepositoryException
    {
        accessor = new ObjectAccessor(getRepository());
    }

    @Test
    public void findObjects() throws RepositoryException
    {
        FieldSearchQuery query = new FieldSearchQuery();
        //query.setTerms("easy-file:*");
        Condition condition = new Condition("pid", ComparisonOperator.has, "easy-dataset:*");
        query.setConditions(new Condition[] {condition});

        FieldSearchResult result = accessor.findObjects(new String[] {"pid", "label"}, 100, query);
        String token = printResult(result);
        while (token != null)
        {
            result = accessor.resumeFindObjects(token);
            token = printResult(result);
        }
    }

    private String printResult(FieldSearchResult result)
    {
        ObjectFields[] objectFields = result.getResultList();
        for (ObjectFields of : objectFields)
        {
            logger.debug(of.getPid() + " " + of.getLabel());
        }
        String token = null;
        if (result.getListSession() != null)
        {
            token = result.getListSession().getToken();
            logger.debug(token);
            logger.debug("" + result.getListSession().getCompleteListSize());
            logger.debug("" + result.getListSession().getCursor());
            logger.debug(result.getListSession().getExpirationDate());
        }
        return token;
    }

}
