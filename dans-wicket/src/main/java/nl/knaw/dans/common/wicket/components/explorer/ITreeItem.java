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
package nl.knaw.dans.common.wicket.components.explorer;

import java.util.ArrayList;

public interface ITreeItem
{
    public static enum Type
    {
        FILE, FOLDER
    };

    public void addChild(ITreeItem item);

    public ArrayList getChildren();

    public ArrayList getChildrenWithFiles();

    public ITreeItem getParent();

    public Type getType();

    public String getId();

    public boolean isLoaded();

    public void setLoaded(boolean loaded);

    public String getName();
}
