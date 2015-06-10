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
package nl.knaw.dans.common.wicket;

import java.io.Serializable;

import org.apache.wicket.Page;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WicketCommonTestBase implements Serializable
{
    private static final long serialVersionUID = 7303398653319815055L;

    private static Logger logger = LoggerFactory.getLogger(WicketCommonTestBase.class);

    protected CommonWicketApplication application;

    protected CommonWicketTester tester;

    @Before
    public void before()
    {
        application = new CommonWicketApplication()
        {
            @Override
            public Class<? extends Page> getHomePage()
            {
                return HomeTestPage.class;
            }
        };

        tester = new CommonWicketTester(application);
        tester.startPage(application.getHomePage());
    }

}
