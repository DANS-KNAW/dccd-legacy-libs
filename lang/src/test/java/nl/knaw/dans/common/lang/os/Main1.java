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

import java.io.IOException;

public class Main1
{

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
        System.out.println("MAIN1 > Hello, this is " + Main1.class.getName());

        System.out.println("MAIN1 > Now executing Main2");

        String cmd = "/usr/local/vm-data/SVN/common/trunk/lang/src/test/resources/test-files/os/ostest2.sh";
        int exitValue = OS.execAndWait(cmd, System.out, System.err);

        System.out.println("MAIN1 > Main2 has exited with exit value " + exitValue);
        System.exit(exitValue);
    }

}
