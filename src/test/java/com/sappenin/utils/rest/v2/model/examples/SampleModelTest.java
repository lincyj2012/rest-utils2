package com.sappenin.utils.rest.v2.model.examples;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.collect.ImmutableMap;
import com.sappenin.utils.rest.v2.InternalId;
import com.sappenin.utils.rest.v2.model.Link;

public class SampleModelTest
{
	private static final String SELF_MODEL_AS_JSON = "{\"meta\":{\"@self\":{\"href\":\"https://example.com/self\"},\"@children\":{\"href\":\"https://example.com/children\"}},\"additionalAttributes\":{},\"name\":\"testName\",\"creationDateTime\":\"2014-12-20T19:28:21Z\",\"id\":\"internalIdentifierTest\"}";

	private ObjectMapper objectMapper;

	private Link selfLink;
	private Link childrenLink;
	private SampleMeta sampleMeta;

	private String name;
	private DateTime creationDateTime;
	private Map<String, String> additionalAttributes;
	private InternalId internalId;
	private SampleModel sampleModel;

	@Before
	public void before() throws MalformedURLException
	{
		this.objectMapper = new ObjectMapper();
		this.objectMapper.registerModule(new JodaModule());
		this.objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		this.objectMapper.setDateFormat(new ISO8601DateFormat());

		this.selfLink = Link.build(new URL("https://example.com/self"));
		this.childrenLink = Link.build(new URL("https://example.com/children"));
		this.sampleMeta = new SampleMeta(this.selfLink, this.childrenLink);

		this.name = "testName";
		this.creationDateTime = DateTime.parse("2014-12-20T19:28:21Z");
		this.additionalAttributes = ImmutableMap.of();
		this.internalId = new InternalId("internalIdentifierTest");
		this.sampleModel = new SampleModel(this.sampleMeta, this.internalId, this.additionalAttributes, this.name,
			this.creationDateTime);
	}

	@Test
	public void testSerializeDeserialize() throws IOException
	{
		final String serializedJson = this.objectMapper.writeValueAsString(sampleModel);
		final String expectedJson = SELF_MODEL_AS_JSON;
		assertThat(serializedJson, is(expectedJson));

		final SampleModel deserializedObject = this.objectMapper.readValue(SELF_MODEL_AS_JSON, SampleModel.class);
		assertThat(deserializedObject, is(sampleModel));
	}

	@Test
	public void testEquals() throws Exception
	{
		final SampleModel sampleModel2 = new SampleModel(this.sampleMeta, this.internalId, this.additionalAttributes,
			this.name, this.creationDateTime);
		assertThat(sampleModel, is(sampleModel2));
	}

	@Test
	public void testHashCode() throws Exception
	{
		final SampleModel sampleModel2 = new SampleModel(this.sampleMeta, this.internalId, this.additionalAttributes,
			this.name, this.creationDateTime);
		assertThat(sampleModel.hashCode(), is(sampleModel2.hashCode()));
	}

	@Test
	public void testGetMeta() throws Exception
	{
		assertThat(sampleModel.getMeta(), is(this.sampleMeta));
	}

	@Test
	public void testGetName() throws Exception
	{
		assertThat(sampleModel.getName(), is(this.name));
	}

	@Test
	public void testGetCreationDateTime() throws Exception
	{
		assertThat(sampleModel.getCreationDateTime(), is(creationDateTime));
	}

	@Test
	public void testGetAdditionalAttributes() throws Exception
	{
		assertThat(sampleModel.getAdditionalAttributes(), is(additionalAttributes));
	}

	@Test
	public void testGetInternalId() throws Exception
	{
		assertThat(sampleModel.getId(), is(internalId));
	}

	@Test
	public void testToString() throws Exception
	{
		assertThat(
			sampleModel.toString(),
			is("SampleModel(super=AbstractRestModel(meta=SampleMeta(super=AbstractMeta(selfLink=Link(hrefUrl=https://example.com/self)), childrenLink=Link(hrefUrl=https://example.com/children)), id=InternalId(internalId=internalIdentifierTest), additionalAttributes={}), name=testName, creationDateTime=2014-12-20T19:28:21.000Z)"));
	}

	@Test
	public void testCopyConstructor() throws Exception
	{
		SampleModel sampleModel2 = new SampleModel(this.sampleModel);
		assertThat(sampleModel, is(sampleModel2));
	}
}