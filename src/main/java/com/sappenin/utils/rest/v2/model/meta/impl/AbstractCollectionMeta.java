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
package com.sappenin.utils.rest.v2.model.meta.impl;

import com.sappenin.utils.rest.v2.model.Link;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sappenin.utils.rest.v2.model.meta.CollectionMeta;

/**
 * A AbstractMeta object for storing read-only information about a Collection of resources.
 */
@JsonTypeName("meta")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public abstract class AbstractCollectionMeta extends AbstractMeta implements CollectionMeta
{
	private static final long serialVersionUID = 7323709012810641819L;

	// An encoded value that represents the next starting index in the entire Collection of items to return. Omit to
	// return results from the beginning of the Collection.
	private final String offset;

	// An array containing a listing of Objects of any object type. If used in combination with the url property, the
	// items array can be used to provide a subset of the objects that may be found in the resource identified by the
	// url. The maximum number of collection items N to return for a single request. Minimum value is 1. Max is 50.
	// Default is 25.
	private final int limit;

	// An (Optional) total number as set by the server (this can be bigger than the size of the items array, which is
	// merely a paged sub-collection).
	private final Long totalItems;

	// TODO Links for previous, next, href, current.


	/**
	 * Required-args Constructor
	 *
	 * @param selfLink A {@link Link} to this collection.
	 */
	public AbstractCollectionMeta(final Link selfLink)
	{
		super(selfLink);
		this.offset = null;
		this.limit = DEFAULT_LIMIT;
		this.totalItems = null;
	}

	/**
	 * Required-args Constructor
	 * 
	 * @param selfLink A {@link Link} to this collection.
	 * @param limit
	 * @param totalItems
	 */
	public AbstractCollectionMeta(@JsonProperty("@self") final Link selfLink,
			@JsonProperty("offset") final String offset, @JsonProperty("limit") int limit,
			@JsonProperty("totalItems") final long totalItems)
	{
		super(selfLink);

		this.offset = offset;
		this.limit = limit;
		this.totalItems = totalItems;
	}

	/**
	 * Copy Constructor.
	 * 
	 * @param collectionMeta
	 */
	public AbstractCollectionMeta(final CollectionMeta collectionMeta)
	{
		super(collectionMeta);
		this.offset = collectionMeta.getOffset();
		this.limit = collectionMeta.getLimit();
		this.totalItems = collectionMeta.getTotalItems();
	}
}