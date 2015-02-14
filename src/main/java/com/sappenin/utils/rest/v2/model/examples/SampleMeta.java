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
package com.sappenin.utils.rest.v2.model.examples;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sappenin.utils.rest.v2.model.Link;
import com.sappenin.utils.rest.v2.model.meta.Meta;
import com.sappenin.utils.rest.v2.model.meta.impl.AbstractMeta;

/**
 * An example implementation of {@link Meta} that extends {@link AbstractMeta}.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SampleMeta extends AbstractMeta implements Meta
{
	private static final long serialVersionUID = 8407518536812877744L;

	// An example URL pointer to the child of this resource.
	@JsonProperty("@children")
	private final Link childrenLink;

	/**
	 * Required-args Constructor
	 * 
	 * @param selfLink
	 */
	public SampleMeta(@JsonProperty("@self") final Link selfLink, @JsonProperty("@sampleChild") final Link childrenLink)
	{
		super(selfLink);
		this.childrenLink = childrenLink;
	}

	/**
	 * Copy Constructor.
	 * 
	 * @param sampleMeta
	 */
	public SampleMeta(final SampleMeta sampleMeta)
	{
		this(sampleMeta.getSelfLink(), sampleMeta.getChildrenLink());
	}
}
