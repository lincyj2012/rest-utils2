package com.sappenin.utils.rest.v2.model.paging;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.sappenin.utils.rest.v2.model.paging.Sort.SortDirection;

/**
 * A container for holding an offset, limit, and optional sort parameter that indicates the sorted field and a sort
 * direction.
 */
@RequiredArgsConstructor
@Data(staticConstructor = "of")
public class PagableQueryParams
{
	@NonNull
	private final Optional<String> optOffset;

	@NonNull
	private final Optional<Integer> optLimit;

	@NonNull
	private final Optional<SortDirection> optSortDirection;

	// Callers may set this to true to expand all expandable sub-resources in a pagable collection. For more customized
	// expando operations, clients should implement their own functionality.
	@NonNull
	private final Optional<Boolean> optExpand;

	/**
	 * No-args Constructor.
	 */
	public PagableQueryParams()
	{
		this.optOffset = Optional.absent();
		this.optLimit = Optional.absent();
		this.optSortDirection = Optional.absent();
		this.optExpand = Optional.absent();
	}

	public PagableQueryParams(final Optional<String> optOffset, final Optional<Integer> optLimit)
	{
		Preconditions.checkNotNull(optOffset);
		Preconditions.checkNotNull(optLimit);

		this.optOffset = optOffset;
		this.optLimit = optLimit;
		this.optSortDirection = Optional.absent();
		this.optExpand = Optional.absent();
	}

	/**
	 * Helper method to create an empty {@link PagableQueryParams}.
	 * 
	 * @return
	 */
	public static PagableQueryParams of()
	{
		return new PagableQueryParams(Optional.<String> absent(), Optional.<Integer> absent());
	}

	/**
	 * Helper method to create an empty {@link PagableQueryParams}.
	 * 
	 * @return
	 */
	public static PagableQueryParams of(final Optional<String> optOffset, final Optional<Integer> optLimit)
	{
		return new PagableQueryParams(optOffset, optLimit, Optional.<SortDirection> absent(),
			Optional.<Boolean> absent());
	}
}
