package com.sappenin.utils.rest.v2.model;

import java.net.URL;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A link to another resource, possibly with a type.
 */
@Getter
@EqualsAndHashCode
@ToString
public class Link
{
	// Must be a URL so that it's can be both unique and de-referencable.
	@JsonProperty("href")
	private final URL hrefUrl;

	/**
	 * Required Args Constructor.
	 * 
	 * @param hrefUrl A {@link URL} that can identify and locate a resource.
	 */
	public Link(@JsonProperty("href") final URL hrefUrl)
	{
		this.hrefUrl = hrefUrl;
	}

	/**
	 * A builder for a {@link Link}.
	 *
	 * @param hrefUrl
	 * @return
	 */
	public static Link build(final URL hrefUrl)
	{
		return new Link(hrefUrl);
	}

}
