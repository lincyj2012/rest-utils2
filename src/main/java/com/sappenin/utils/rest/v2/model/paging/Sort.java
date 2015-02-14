package com.sappenin.utils.rest.v2.model.paging;

import lombok.Data;
import lombok.NonNull;

/**
 * A container class used to indicate information about how a REST request should be sorted using query-parameters.
 */
@Data(staticConstructor = "of")
public class Sort
{
	// The typical value of a query-parameter name for sorting direction (e.g., "sortDir=asc").
	public static final String SORT_DIRECTION_QUERY_PARAM_NAME = "sortDir";

	// The typical value of a query-parameter name for sorting (e.g., "sort=firstName").
	public static final String SORT_QUERY_PARAM_NAME = "sort";

	@NonNull
	private final String sortPropertyName;

	@NonNull
	private final SortDirection sortDirection;

	/**
	 * An enumeration of possible SortDirections.
	 */
	public static enum SortDirection
	{
		ASCENDING("asc"), DESCENING("desc");

		private String value;

		/**
		 * Required Args Constructor
		 * 
		 * @param value
		 */
		private SortDirection(final String value)
		{
			this.value = value;
		}

		@Override
		public String toString()
		{
			return this.value;
		}

	}
}
