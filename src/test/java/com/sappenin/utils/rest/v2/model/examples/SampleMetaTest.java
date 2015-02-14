package com.sappenin.utils.rest.v2.model.examples;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sappenin.utils.rest.v2.model.Link;

/**
 * A unit test for {@link SampleMeta}, which by inference also tests the super-class heirarchy.
 */
public class SampleMetaTest
{
	private static final String SELF_META_AS_JSON = "{\"@self\":{\"href\":\"https://example.com/self\"},\"@children\":{\"href\":\"https://example.com/children\"}}";

	private ObjectMapper objectMapper;

	private Link selfLink;
	private Link childrenLink;
	private SampleMeta sampleMeta;

	@Before
	public void before() throws MalformedURLException
	{
		this.objectMapper = new ObjectMapper();

		this.selfLink = Link.build(new URL("https://example.com/self"));
		this.childrenLink = Link.build(new URL("https://example.com/children"));
		this.sampleMeta = new SampleMeta(selfLink, childrenLink);
	}

	@Test
	public void testSerializeDeserialize() throws IOException
	{
		final String serializedSampleMetaJson = this.objectMapper.writeValueAsString(sampleMeta);
		final String expectedSampleMetaJson = SELF_META_AS_JSON;
		assertThat(serializedSampleMetaJson, is(expectedSampleMetaJson));

		final SampleMeta deserializedSampleMeta = this.objectMapper.readValue(SELF_META_AS_JSON, SampleMeta.class);
		assertThat(deserializedSampleMeta, is(sampleMeta));
	}

	@Test
	public void testEquals() throws Exception
	{
		final SampleMeta sampleMeta2 = new SampleMeta(selfLink, childrenLink);
		assertThat(sampleMeta, is(sampleMeta2));
	}

	@Test
	public void testHashCode() throws Exception
	{
		final SampleMeta sampleMeta2 = new SampleMeta(selfLink, childrenLink);
		assertThat(sampleMeta.hashCode(), is(sampleMeta2.hashCode()));
	}

	@Test
	public void testGetChildrenLink() throws Exception
	{
		assertThat(sampleMeta.getChildrenLink(), is(childrenLink));
	}

	@Test
	public void testToString() throws Exception
	{
		assertThat(
			sampleMeta.toString(),
			is("SampleMeta(super=AbstractMeta(selfLink=Link(hrefUrl=https://example.com/self)), childrenLink=Link(hrefUrl=https://example.com/children))"));
	}

	@Test
	public void testCopyConstructor() throws Exception
	{
		SampleMeta sampleMeta2 = new SampleMeta(this.sampleMeta);
		assertThat(sampleMeta, is(sampleMeta2));
	}
}