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

import java.io.Serializable;
import java.util.Map;

import com.sappenin.utils.rest.v2.InternalId;
import com.sappenin.utils.rest.v2.model.meta.Meta;
import com.sappenin.utils.rest.v2.model.meta.impl.AbstractMeta;

/**
 * Basic interface for all rest model objects. <br/>
 * <br/>
 * <M> is the type of AbstractMeta object that this interface holds.
 */
public interface RestModel<M extends Meta> extends Serializable
{
	/**
	 * Get this object's {@link AbstractMeta}.
	 * 
	 * @return
	 */
	public M getMeta();

	/**
	 * An object that represents the server-side internal identifier of a resource. This can internally hold something
	 * like an integer, long number or other type as a String identifier that both client and server can use to aid in
	 * locating the actual resource.
	 * 
	 * @return
	 */
	public InternalId getId();

	/**
	 * @return
	 */
	public Map<String, String> getAdditionalAttributes();

}
