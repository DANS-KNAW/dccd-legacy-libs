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
package nl.knaw.dans.common.lang.security.authz;

import java.io.Serializable;
import java.util.List;

import nl.knaw.dans.common.lang.user.User;

/**
 * Handles authorization to a target resource or resource aggregation 
 * within a given context.
 * <p/>
 * If the target is a DataModelObject (DMO), AuthzStrategy should have methods whether
 * <ol>
 * <li>the DMO itself,</li>
 * <li>one of its units (datastreams in Fedora terminology),</li>
 * <li>the children of the DMO (in case DMO is a container)</li>
 * </ol>
 * can be discovered, read, written or deleted, given a certain context. 
 * <p/>
 * The following image tries to clarify the above lines.
 * <p/>
 * <img src="doc-files/AuthzStrategy-1.png" height="400px" width="900px" alt="classdiagram of AuthzStrategy and target DMO"/>
 * <p/>
 * AuthzStrategy-1.png
 * 
 *
 */
public interface AuthzStrategy extends Serializable
{

    /**
     * The state of a resource or resource aggregation in respect to authorization for certain handling.
     *
     */
    enum TriState
    {
        NONE, SOME, ALL
    }

    boolean canBeDiscovered();

    boolean canBeRead();

    //    boolean canBeWritten();
    //    boolean canBeDeleted();

    boolean canUnitBeDiscovered(String unitId);

    boolean canUnitBeRead(String unitId);

    TriState canChildrenBeDiscovered();

    TriState canChildrenBeRead();

    String explainCanChildrenBeDiscovered();

    List<AuthzMessage> getReadMessages();

    AuthzMessage getSingleReadMessage();

    AuthzStrategy newStrategy(User user, Object target, Object... contextObjects);

    AuthzStrategy sameStrategy(Object target);

}
