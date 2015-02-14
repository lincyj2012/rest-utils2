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
package com.sappenin.utils.rest.v2.model.meta;

/**
 * An extension interface of {@link Meta} that provides read-only information for Collection resources.
 */
public interface CollectionMeta extends Meta
{
	// The default number of items in a FollieCollection when no limit is specified.
	public static final int DEFAULT_LIMIT = 15;

	// The default number of items in a FollieCollection when no limit is specified.
	public static final int DEFAULT_MAX_COLLECTION_ITEMS = 50;

	// TODO Links for previous, next, href, current.

	/**
	 * @return the offset
	 */
	public String getOffset();

	/**
	 * @return the limit
	 */
	public int getLimit();

	/**
	 * The total items in the entire collection (not just this page).
	 * 
	 * @return the totalItems
	 */
	public Long getTotalItems();

}