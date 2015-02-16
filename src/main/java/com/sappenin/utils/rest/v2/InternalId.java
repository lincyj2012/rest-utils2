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
package com.sappenin.utils.rest.v2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Preconditions;

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

/**
 * A typed internal identifier that represents the server-side internal identifier of a resource. This can internally
 * hold something like an integer, long number or other type as a String identifier that both client and server can use
 * to aid in locating the actual resource.
 */
@Getter
@EqualsAndHashCode
@ToString
public class InternalId
{
	@JsonUnwrapped
	private final String internalId;

	/**
	 * Required-args Constructor.
	 * 
	 * @param internalId
	 */
	public InternalId(final String internalId)
	{
		Preconditions.checkArgument(!StringUtils.isBlank(internalId), "Id may not be empty, blank, or null!");
		this.internalId = internalId;
	}

	@JsonValue
	public String getId()
	{
		return this.internalId;
	}

}
