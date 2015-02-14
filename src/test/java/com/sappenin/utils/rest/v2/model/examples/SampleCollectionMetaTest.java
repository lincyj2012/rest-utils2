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
 * A unit test for {@link SampleCollectionMeta}, which by inference also tests the super-class heirarchy.
 */
public class SampleCollectionMetaTest
{
	private static final String SELF_META_AS_JSON = "{\"@self\":{\"href\":\"https://example.com/self\"},\"offset\":null,\"limit\":15,\"totalItems\":null,\"sampleChildLink\":{\"href\":\"https://example.com/child\"}}";

	private ObjectMapper objectMapper;

	private Link selfLink;
	private Link sampleChildLink;
	private SampleCollectionMeta sampleCollectionMeta;

	@Before
	public void before() throws MalformedURLException
	{
		this.objectMapper = new ObjectMapper();

		this.selfLink = Link.build(new URL("https://example.com/self"));
		this.sampleChildLink = Link.build(new URL("https://example.com/child"));
		this.sampleCollectionMeta = new SampleCollectionMeta(selfLink, sampleChildLink);
	}

	@Test
	public void testSerializeDeserialize() throws IOException
	{
		final String serializedSampleCollectionMetaJson = this.objectMapper.writeValueAsString(sampleCollectionMeta);
		final String expectedSampleCollectionMetaJson = SELF_META_AS_JSON;
		assertThat(serializedSampleCollectionMetaJson, is(expectedSampleCollectionMetaJson));

		final SampleCollectionMeta deserializedSampleCollectionMeta = this.objectMapper.readValue(SELF_META_AS_JSON,
			SampleCollectionMeta.class);
		assertThat(deserializedSampleCollectionMeta, is(sampleCollectionMeta));
	}

	@Test
	public void testEquals() throws Exception
	{
		final SampleCollectionMeta sampleMeta2 = new SampleCollectionMeta(selfLink, sampleChildLink);
		assertThat(sampleCollectionMeta, is(sampleMeta2));
	}

	@Test
	public void testHashCode() throws Exception
	{
		final SampleCollectionMeta sampleMeta2 = new SampleCollectionMeta(selfLink, sampleChildLink);
		assertThat(sampleCollectionMeta.hashCode(), is(sampleMeta2.hashCode()));
	}

	@Test
	public void testGetChildrenLink() throws Exception
	{
		assertThat(sampleCollectionMeta.getSampleChildLink(), is(sampleChildLink));
	}

	@Test
	public void testToString() throws Exception
	{
		assertThat(
			sampleCollectionMeta.toString(),
			is("SampleCollectionMeta(super=AbstractCollectionMeta(offset=null, limit=15, totalItems=null), sampleChildLink=Link(hrefUrl=https://example.com/child))"));
	}

	@Test
	public void testCopyConstructor() throws Exception
	{
		SampleCollectionMeta sampleMeta2 = new SampleCollectionMeta(this.sampleCollectionMeta);
		assertThat(sampleCollectionMeta, is(sampleMeta2));
	}
}