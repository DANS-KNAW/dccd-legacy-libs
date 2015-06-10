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

public enum AccessCategory
{
    /**
     * An anonymous user is enabled, must agree with license.
     */
    ANONYMOUS_ACCESS,
    /**
     * A known user is enabled, must agree with license.
     */
    OPEN_ACCESS,
    /**
     * Members of a (specific) group are enabled, must agree with license.
     */
    GROUP_ACCESS,
    /**
     * Users that have been granted permission are enabled, must agree with license.
     */
    REQUEST_PERMISSION,
    /**
     * Physical files are elsewhere.
     */
    ACCESS_ELSEWHERE,
    /**
     * Not enabled, but archivists and administrators may be enabled.
     */
    NO_ACCESS,
    /**
     * Everyone is enabled, no need to agree with license.
     */
    FREELY_AVAILABLE;

    public static final StateUtil<AccessCategory> UTIL = new StateUtil<AccessCategory>(values());

    /**
     * Bit mask for ACCESS_ELSEWHERE, NO_ACCESS.
     */
    public static final int MASK_INACCESSIBLE = UTIL.getBitMask(ACCESS_ELSEWHERE, NO_ACCESS);

    /**
     * Bit mask for ANONYMOUS_ACCESS, FREELY_AVAILABLE.
     */
    public static final int MASK_ANONYMOUS = UTIL.getBitMask(ANONYMOUS_ACCESS, FREELY_AVAILABLE);

    /**
     * Bit mask for ANONYMOUS_ACCESS, OPEN_ACCESS, FREELY_AVAILABLE.
     */
    public static final int MASK_KNOWN = UTIL.getBitMask(ANONYMOUS_ACCESS, OPEN_ACCESS, FREELY_AVAILABLE);

    /**
     * Bit mask for all categories.
     */
    public static final int MASK_ALL = UTIL.getBitMask(ANONYMOUS_ACCESS, OPEN_ACCESS, GROUP_ACCESS, REQUEST_PERMISSION, NO_ACCESS, FREELY_AVAILABLE);

    /**
     * Bit mask for OPEN_ACCESS.
     */
    public static final int SINGLE_OPEN_ACCESS = UTIL.getBitMask(OPEN_ACCESS);

    /**
     * Bit mask for GROUP_ACCESS.
     */
    public static final int SINGLE_GROUP_ACCESS = UTIL.getBitMask(GROUP_ACCESS);

    /**
     * Bit mask for REQUEST_PERMISSION.
     */
    public static final int SINGLE_REQUEST_PERMISSION = UTIL.getBitMask(REQUEST_PERMISSION);

    public static boolean isAccessible(AccessCategory category)
    {
        int mask = 1 << category.ordinal();
        return !((MASK_INACCESSIBLE & mask) == mask);
    }

    /**
     * Open access specified as Open Access, Freely available resources. In fact:
     * 
     * <pre>
     * ANONYMOUS_ACCESS || OPEN_ACCESS
     * </pre>
     * 
     * @param category
     *        AccessCategory to test
     * @return <code>true</code> if <code>category</code> is ANONYMOUS_ACCESS or OPEN_ACCESS, <code>false</code> otherwise
     */
    public static boolean isOpenAccess(AccessCategory category)
    {
        int mask = 1 << category.ordinal();
        return ((MASK_KNOWN & mask) == mask);
    }

}
