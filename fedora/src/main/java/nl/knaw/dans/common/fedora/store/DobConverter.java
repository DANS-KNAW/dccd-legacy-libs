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
package nl.knaw.dans.common.fedora.store;

import nl.knaw.dans.common.fedora.fox.DigitalObject;
import nl.knaw.dans.common.lang.repo.DataModelObject;
import nl.knaw.dans.common.lang.repo.DmoNamespace;
import nl.knaw.dans.common.lang.repo.exception.ObjectDeserializationException;
import nl.knaw.dans.common.lang.repo.exception.ObjectSerializationException;

public interface DobConverter<T extends DataModelObject>
{
    DmoNamespace getObjectNamespace();

    /**
     * Serialize the given dmo to a {@link DigitalObject}.
     * @param dmo the dmo to serialize
     * @return DigitalObject representation of the given dmo
     * @throws ObjectSerializationException if the dmo could not be serialized
     */
    DigitalObject serialize(T dmo) throws ObjectSerializationException;

    /**
     * Deserialize the given DigitalObject to the given dmo.
     * @param dob DigitalObject as input
     * @param dmo DataModelObject as output
     * @throws ObjectDeserializationException if the DigitalObject could not be deserialized
     */
    void deserialize(DigitalObject dob, T dmo) throws ObjectDeserializationException;

    // hack: update of dmo bypasses dobconverter and setting of parentDisciplines
    void prepareForUpdate(T dmo) throws ObjectSerializationException;

}
