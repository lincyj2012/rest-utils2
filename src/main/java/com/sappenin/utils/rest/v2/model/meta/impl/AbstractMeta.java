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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.base.Preconditions;
import com.sappenin.utils.rest.v2.model.Link;
import com.sappenin.utils.rest.v2.model.meta.Meta;

/**
 * A abstract implementation of {@link Meta}.
 */

@JsonTypeName("meta")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class AbstractMeta implements Meta
{
	private static final long serialVersionUID = -4056669413015645534L;

	// Provides a permanent, universally unique, and dereferencable identifier for the representation, in the form of a
	// URL.
	@JsonProperty("@self")
	private final Link selfLink;

	/**
	 * Required-args Constructor
	 *
	 * @param selfLink
	 */
	public AbstractMeta(@JsonProperty("@self") final Link selfLink)
	{
		Preconditions.checkNotNull(selfLink);
		this.selfLink = selfLink;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param meta
	 */
	public AbstractMeta(final Meta meta)
	{
		Preconditions.checkNotNull(meta);
		this.selfLink = meta.getSelfLink();
	}
}
