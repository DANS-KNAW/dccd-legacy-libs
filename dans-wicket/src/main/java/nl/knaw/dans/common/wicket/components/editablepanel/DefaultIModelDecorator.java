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
package nl.knaw.dans.common.wicket.components.editablepanel;

import org.apache.wicket.model.IModel;

/**
 * An <code>IModel</code> implementation that forwards all calls to a decorated <code>IModel</code>.
 * Intended to be subclassed by decorators that need to override only part of the IModel interface.
 * 
 * @param <T>
 *        the type parameter of the decorated <code>IModel</code> object
 */
public class DefaultIModelDecorator<T> implements IModel<T>
{
    private static final long serialVersionUID = -9222209948850020288L;

    protected final IModel<T> decoratee;

    /**
     * Constructs a new {@link DefaultIModelDecorator}.
     * 
     * @param decoratee
     *        the <code>IModel</code> object being decorated
     */
    protected DefaultIModelDecorator(IModel<T> decoratee)
    {
        this.decoratee = decoratee;
    }

    @Override
    public void detach()
    {
        decoratee.detach();
    }

    @Override
    public T getObject()
    {
        return decoratee.getObject();
    }

    @Override
    public void setObject(T object)
    {
        decoratee.setObject(object);
    }
}
