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
package nl.knaw.dans.common.lang.repo;

import java.io.Serializable;
import java.util.HashMap;

import nl.knaw.dans.common.lang.repo.exception.CouldNotGetStoreException;
import nl.knaw.dans.common.lang.repo.exception.StoreNameNotUniqueException;

/**
 * A singleton object that holds a list of uniquely named dmo stores. These dmo
 * currently register themselves during their creation process.
 * 
 * Note: This class does not store the stores with weak references, therefore once
 *  a store is created and registered it exists forever, because the singleton
 *  will keep the references forever.   
 * 
 * @author lobo
 */
public class DmoStores implements Serializable
{
    private static final long serialVersionUID = 1468152880397856857L;

    private static DmoStores INSTANCE = new DmoStores();

    private HashMap<String, DmoStore> stores = new HashMap<String, DmoStore>();

    private DmoStores()
    {
    }

    /**
     * @return the DmoStores singleton that holds the list of dmo stores.
     */
    public static DmoStores get()
    {
        return INSTANCE;
    }

    /**
     * Returns a store by its name.
     * @throws CouldNotGetStoreException if the store does not exist
     */
    public DmoStore getStoreByName(String name) throws CouldNotGetStoreException
    {
        DmoStore store = stores.get(name);
        if (store == null)
            throw new CouldNotGetStoreException(name);
        return store;
    }

    /**
     * Package level method that gets called by the constructor of a data model 
     * object store.
     * @param store the store
     */
    public synchronized void register(DmoStore store)
    {
        String storeName = store.getName();
        stores.put(storeName, store);
    }
}
