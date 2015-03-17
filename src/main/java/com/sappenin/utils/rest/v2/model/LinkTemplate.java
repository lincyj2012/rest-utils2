package com.sappenin.utils.rest.v2.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;

/**
 * A link to another resource, possibly with a type.
 */
@Getter
@EqualsAndHashCode
@ToString
public class LinkTemplate
{
	private final String hrefTemplate;

	/**
	 * Required Args Constructor.
	 *
	 * @param hrefTemplate
	 */
	public LinkTemplate(@JsonProperty("href") final String hrefTemplate)
	{
		this.hrefTemplate = hrefTemplate;
	}

	/**
	 * A builder for a {@link LinkTemplate}.
	 *
	 * @param hrefTemplate
	 * @return
	 */
	public static LinkTemplate build(final String hrefTemplate)
	{
		Preconditions.checkNotNull(hrefTemplate);
		return new LinkTemplate(hrefTemplate);
	}

}
