package com.sappenin.utils.rest.v2.model.examples;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.sappenin.utils.rest.v2.model.Link;

public class SampleCollectionModelTest
{
	private static final String SELF_MODEL_AS_JSON = "{\"meta\":{\"@self\":{\"href\":\"https://example.com/self\"},\"offset\":null,\"limit\":15,\"totalItems\":null,\"sampleChildLink\":{\"href\":\"https://example.com/children\"}},\"numberOfSomethingElseRelated\":22,\"pageItems\":[]}";

	private ObjectMapper objectMapper;

	private Link selfLink;
	private Link childrenLink;
	private SampleCollectionMeta sampleCollectionMeta;

	private long numberOfSomethingElseRelated;
	private SampleCollectionModel sampleCollectionModel;

	@Before
	public void before() throws MalformedURLException
	{
		this.objectMapper = new ObjectMapper();
		this.objectMapper.registerModule(new JodaModule());
		this.objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		this.objectMapper.setDateFormat(new ISO8601DateFormat());

		this.selfLink = Link.build(new URL("https://example.com/self"));
		this.childrenLink = Link.build(new URL("https://example.com/children"));
		this.sampleCollectionMeta = new SampleCollectionMeta(this.selfLink, this.childrenLink);

		this.numberOfSomethingElseRelated = 22L;
		this.sampleCollectionModel = new SampleCollectionModel(this.sampleCollectionMeta,
			this.numberOfSomethingElseRelated);
	}

	@Test
	public void testSerializeDeserialize() throws IOException
	{
		final String serializedJson = this.objectMapper.writeValueAsString(sampleCollectionModel);
		final String expectedJson = SELF_MODEL_AS_JSON;
		assertThat(serializedJson, is(expectedJson));

		final SampleCollectionModel deserializedObject = this.objectMapper.readValue(SELF_MODEL_AS_JSON,
			SampleCollectionModel.class);
		assertThat(deserializedObject, is(sampleCollectionModel));
	}

	@Test
	public void testEquals() throws Exception
	{
		final SampleCollectionModel sampleModel2 = new SampleCollectionModel(this.sampleCollectionMeta,
			this.numberOfSomethingElseRelated);
		assertThat(sampleCollectionModel, is(sampleModel2));
	}

	@Test
	public void testHashCode() throws Exception
	{
		final SampleCollectionModel sampleModel2 = new SampleCollectionModel(this.sampleCollectionMeta,
			this.numberOfSomethingElseRelated);
		assertThat(sampleCollectionModel.hashCode(), is(sampleModel2.hashCode()));
	}

	@Test
	public void testGetMeta() throws Exception
	{
		assertThat(sampleCollectionModel.getMeta(), is(this.sampleCollectionMeta));
	}

	@Test
	public void testGetName() throws Exception
	{
		assertThat(sampleCollectionModel.getNumberOfSomethingElseRelated(), is(this.numberOfSomethingElseRelated));
	}

	@Test
	public void testNumberOfSomethingElseRelated() throws Exception
	{
		assertThat(sampleCollectionModel.getNumberOfSomethingElseRelated(), is(this.numberOfSomethingElseRelated));
	}

	@Test
	public void testToString() throws Exception
	{
		assertThat(
			sampleCollectionModel.toString(),
			is("SampleCollectionModel(super=AbstractRestCollection(meta=SampleCollectionMeta(super=AbstractCollectionMeta(offset=null, limit=15, totalItems=null), sampleChildLink=Link(hrefUrl=https://example.com/children)), pageItems=[]), numberOfSomethingElseRelated=22)"));
	}

}