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
package nl.knaw.dans.common.lang.log;

import org.junit.Ignore;
import org.junit.Test;

public class RLTest
{

    @Ignore("test creates directories in DEFAULT_REPORT_LOCATION ")
    @Test
    public void noInitialisation()
    {
        RL.reset();
        RL.info(new Event("not initialized", new RuntimeException("knal!"), "message"));
    }

    @Ignore("local environment")
    @Test
    public void initialized() throws Exception
    {
        RL.reset();
        RL rl = RL.initialize("/home/easy/batch/reports/test/enz/en/meer", true);
        TestReporter reporter = new TestReporter();
        reporter.addReport(new OverviewReport());
        rl.setReporter(reporter);
        RL.info(new Event("initialized", new RuntimeException("knal!"), "message2"));
    }

    private class TestReporter extends Reporter
    {
        @Override
        public void info(Event event)
        {
            event.setResourceId("test-id");
            super.info(event);
        }
    }

}
