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
package nl.knaw.dans.common.lang.repo.collections;

/**
 * This object is a container and a container item. It might therefore be called
 * recursive as it may contain itself. A folder is a good example of a recursive 
 * item as in a filesystem it can be contained by another folder and may also 
 * contain folders and files.
 *
 * @author lobo
 */
public interface DmoRecursiveItem extends DmoContainer, DmoContainerItem
{

}
