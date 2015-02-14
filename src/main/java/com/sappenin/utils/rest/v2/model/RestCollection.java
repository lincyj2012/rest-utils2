/**
 * Copyright (C) 2014 Sappenin Inc. (developers@sappenin.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.sappenin.utils.rest.v2.model;

import java.util.List;

import com.sappenin.utils.rest.v2.model.meta.CollectionMeta;
import com.sappenin.utils.rest.v2.model.meta.impl.AbstractMeta;

/**
 * A Generic Representation of a Collection of resources. This class is compliant with ActivityStrea.ms 1.0.<br/>
 * <br/>
 * <T> The type of {@link RestModel} that this collection holds.<br/>
 * <M> The type of {@link AbstractMeta} that this collections' meta object is.
 */
public interface RestCollection<M extends CollectionMeta, T extends RestModel<?>>
{
	/**
	 * Get this object's {@link AbstractMeta}.
	 *
	 * @return
	 */
	public M getMeta();

	/**
	 * @return the items
	 */
	public List<T> getPageItems();

}
