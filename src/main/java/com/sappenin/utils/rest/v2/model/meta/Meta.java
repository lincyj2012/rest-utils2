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

import java.io.Serializable;

import com.sappenin.utils.rest.v2.model.Link;

/**
 * A typed interface for holding read-only meta-data for RESTful representations. Information in meta objects is not
 * meant to be client-supplied (hence, the read-only nature of meta), but is instead always generated by the server. A
 * good rule-of-thumb for deciding which information should exist in a RestMeta object vs. an actual representation is
 * to determine if a particular piece of information can be updated by clients (e.g., via an HTTP PUT operation). Data
 * that can be updated by clients should be considered "normative" resource data, meaning the particular piece of data
 * is required to determine the state of a given resource. Conversely, data that cannot be updated by clients should be
 * considered "informative" to the resource, since it's presence or absence does not affect a client's ability to
 * operate on the full state of a resource that has been received by a server. A good example of informative resource
 * data that cannot be updated by a client is the URL of the resource, which should always be supplied by the server.<br/>
 * <br/>
 * <M> The type of Meta that this object is created for.
 */
public interface Meta extends Serializable
{
	/**
	 * Returns the {@link Link} to the resource represented by this object.
	 * 
	 * @return
	 */
	public Link getSelfLink();
}
