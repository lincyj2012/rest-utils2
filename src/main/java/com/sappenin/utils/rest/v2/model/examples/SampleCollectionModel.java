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
import com.sappenin.utils.rest.v2.model.RestCollection;
import com.sappenin.utils.rest.v2.model.RestModel;
import com.sappenin.utils.rest.v2.model.impl.AbstractRestCollection;

/**
 * An example implementation of {@link RestModel}.
 */
@Getter
@ToString(callSuper = true, exclude = {
	"internalId"
})
@EqualsAndHashCode(callSuper = true, exclude = {
	"internalId"
})
public class SampleCollectionModel extends AbstractRestCollection<SampleCollectionMeta, SampleModel> implements
		RestCollection<SampleCollectionMeta, SampleModel>
{
	private static final long serialVersionUID = 7940258555581761522L;

	// An example property that models a normative attribute called "numberOfSomethingElseRelated"
	private final long numberOfSomethingElseRelated;

	/**
	 * Required-args Constructor
	 * 
	 * @param meta A {@link SampleCollectionMeta} containing meta-data information for this calss.
	 * @param numberOfSomethingElseRelated An example property that models a normative attribute called "name"
	 */
	public SampleCollectionModel(@JsonProperty("meta") final SampleCollectionMeta meta,
			@JsonProperty("numberOfSomethingElseRelated") final long numberOfSomethingElseRelated)
	{
		super(meta);
		this.numberOfSomethingElseRelated = numberOfSomethingElseRelated;
	}

}
