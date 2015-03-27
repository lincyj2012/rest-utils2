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

import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.sappenin.utils.rest.v2.InternalId;
import com.sappenin.utils.rest.v2.model.RestModel;
import com.sappenin.utils.rest.v2.model.meta.Meta;

/**
 * An abstract implementation of {@link RestModel}.
 */
@Getter
@EqualsAndHashCode
@ToString
@JsonPropertyOrder({
	"meta", "id", "additionalAttributes"
})
public abstract class AbstractRestModel<M extends Meta> implements RestModel<M>
{
	private static final long serialVersionUID = 6523915199962689298L;

	private final M meta;

	// An internal identifier for compartmentalized use by server-side or client-side applications.
	private final InternalId id;

	@Getter
	@JsonUnwrapped
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private Map<String, String> additionalAttributes = Maps.newHashMap();

	/**
	 * Required Args Constructor.
	 *
	 * @param meta An instance of <M>.
	 */
	public AbstractRestModel(final M meta)
	{
		// This can occasionally be null, such as when deserializing Json from a client update request.
		this.meta = meta;
		this.id = null;
		this.additionalAttributes = ImmutableMap.of();
	}

	/**
	 * Required Args Constructor.
	 *
	 * @param meta An instance of <M>.
	 * @param id An instance of {@link InternalId} that represents the server-side internal identifier of a resource.
	 *            This can be used to represent something like an integer, long number or other type as a String
	 *            identifier that both client and server can use to aid in locating the actual resource.
	 * @param additionalAttributes An instance of {@link Map} that holds additional attributes for this resource
	 *            representation.
	 */
	public AbstractRestModel(@JsonProperty("meta") final M meta, @JsonProperty("id") final InternalId id,
			@JsonProperty("additionalAttributes") final Map<String, String> additionalAttributes)
	{
		// This can occasionally be null, such as when deserializing Json from a client update request.
		this.meta = meta;
		this.id = id;
		this.additionalAttributes = additionalAttributes == null ? ImmutableMap.<String, String> of()
			: additionalAttributes;
	}

	public AbstractRestModel(final RestModel<M> restModel)
	{
		Preconditions.checkNotNull(restModel);
		this.meta = restModel.getMeta();
		this.id = restModel.getId();
		this.additionalAttributes = restModel.getAdditionalAttributes();
	}

}
