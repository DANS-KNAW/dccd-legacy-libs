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
package nl.knaw.dans.common.lang.util;

import java.util.ArrayList;
import java.util.List;

public class StateUtil<T extends Enum<T>>
{

    private final T[] values;

    public StateUtil(T[] values)
    {
        this.values = values;
    }

    public int getBitMask(List<T> states)
    {
        int b = 0;
        if (states != null)
        {
            for (T state : states)
            {
                b |= 1 << state.ordinal();
            }
        }
        return b;
    }

    public int getBitMask(T... states)
    {
        int b = 0;
        if (states != null)
        {
            for (T state : states)
            {
                b |= 1 << state.ordinal();
            }
        }
        return b;
    }

    public List<T> getStates(int bitMask)
    {
        List<T> states = new ArrayList<T>();
        for (T state : values)
        {
            int mask = 1 << state.ordinal();
            if ((mask & bitMask) == mask)
            {
                states.add(state);
            }
        }
        return states;
    }

}
