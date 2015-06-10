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
package nl.knaw.dans.common.lang.dataset;

import nl.knaw.dans.common.lang.util.StateUtil;

public enum DatasetState
{
    DRAFT, SUBMITTED, PUBLISHED, MAINTENANCE, DELETED;

    public static final StateUtil<DatasetState> UTIL = new StateUtil<DatasetState>(values());

    public static final int MASK_PASSED_SUBMISSION = UTIL.getBitMask(SUBMITTED, PUBLISHED, MAINTENANCE);

    public static boolean isPassedSubmission(DatasetState state)
    {
        if (state == null)
            return false;
        int mask = 1 << state.ordinal();
        return (MASK_PASSED_SUBMISSION & mask) == mask;
    }
}
