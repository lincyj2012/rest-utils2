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

import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sappenin.utils.rest.v2.InternalId;
import com.sappenin.utils.rest.v2.model.RestModel;
import com.sappenin.utils.rest.v2.model.impl.AbstractRestModel;

/**
 * An example implementation of {@link RestModel}.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SampleModel extends AbstractRestModel<SampleMeta> implements RestModel<SampleMeta>
{
	private static final long serialVersionUID = 7940258555581761522L;

	// An example property that models a normative attribute called "name"
	private final String name;

	// An [RFC3339] date-time representing the date and time when this resource was created.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private final DateTime creationDateTime;

	/**
	 * Required-args Constructor
	 * 
	 * @param meta
	 * @param internalId
	 * @param additionalAttributes
	 * @param name
	 * @param creationDateTime
	 */
	public SampleModel(@JsonProperty("meta") final SampleMeta meta,
			@JsonProperty("internalId") final InternalId internalId,
			@JsonProperty("additionalAttributes") final Map<String, String> additionalAttributes,
			@JsonProperty("name") final String name, @JsonProperty("creationDateTime") final DateTime creationDateTime)
	{
		super(meta, internalId, additionalAttributes);
		this.name = name;
		this.creationDateTime = creationDateTime;
	}

	public SampleModel(final SampleModel sampleModel)
	{
		super(sampleModel);
		this.name = sampleModel.getName();
		this.creationDateTime = sampleModel.getCreationDateTime();
	}
}
