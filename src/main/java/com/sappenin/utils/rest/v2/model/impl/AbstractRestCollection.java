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
package com.sappenin.utils.rest.v2.model.impl;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.sappenin.utils.rest.v2.model.RestCollection;
import com.sappenin.utils.rest.v2.model.RestModel;
import com.sappenin.utils.rest.v2.model.meta.CollectionMeta;
import com.sappenin.utils.rest.v2.model.meta.Meta;
import com.sappenin.utils.rest.v2.model.meta.impl.AbstractMeta;

/**
 * A Generic Representation of a Collection of resource representations. This class is compliant with ActivityStrea.ms
 * 1.0.<br/>
 * <br/>
 * <T> The type of {@link RestModel} that this collection holds.<br/>
 * <M> The type of {@link AbstractMeta} that this collections' meta object is.
 */
@Getter
@ToString
@EqualsAndHashCode
public abstract class AbstractRestCollection<M extends CollectionMeta, T extends RestModel<? extends Meta>> implements
		RestCollection<M, T>
{
	private static final long serialVersionUID = 5917831433403834243L;

	// The URL is in the superclass.
	private final M meta;

	private List<T> pageItems = Lists.newArrayList();

	/**
	 * Required-args Constructor
	 * 
	 * @param meta
	 */
	public AbstractRestCollection(final M meta)
	{
		this.meta = meta;
		this.pageItems = ImmutableList.of();
	}

	/**
	 * Required-args Constructor
	 *
	 * @param meta
	 * @param pageItems
	 */
	public AbstractRestCollection(final M meta, final List<T> pageItems)
	{
		this.meta = meta;
		this.pageItems = pageItems;
	}

}
