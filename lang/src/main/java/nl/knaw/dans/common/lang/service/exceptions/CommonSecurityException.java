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
package nl.knaw.dans.common.lang.service.exceptions;

import java.util.List;

public class CommonSecurityException extends ServiceException
{

    public static final String HINT_DATASET_NULL = "dataset.null";
    public static final String HINT_DATASET_UNDER_EMBARGO = "dataset.under.embargo";

    public static final String HINT_SESSION_USER_NULL = "sessionUser.null";
    public static final String HINT_SESSION_USER_NOT_ACTIVE = "sessionUser.not.active";
    public static final String HINT_SESSION_USER_ANONYMOUS = "sessionUser.anonymous";
    public static final String HINT_SESSION_USER_NOT_IN_ROLE = "sessionUser.not.in.role";
    public static final String HINT_SESSION_USER_NOT_DEPOSITOR = "sessionUser.not.depositor";
    public static final String HINT_SESSION_USER_SELF = "sessionUser.is.self";

    private static final long serialVersionUID = 5801106167091636725L;

    private List<Object> hints;

    public CommonSecurityException(String message)
    {
        super(message);
    }

    public CommonSecurityException(String message, List<Object> hints)
    {
        super(message);
        this.hints = hints;
    }

    public CommonSecurityException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CommonSecurityException(Throwable cause)
    {
        super(cause);
    }

    public boolean hasHint(Object object)
    {
        return hints != null && hints.contains(object);
    }

}
