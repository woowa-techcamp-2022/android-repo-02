package com.woowahan.data.issue

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.woowahan.domain.model.Issue
import com.woowahan.domain.repository.IssueRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IssueRepositoryImpl @Inject constructor(
    private val issueDataSourceImpl: IssueDataSourceImpl
): IssueRepository<PagingData<Issue>> {
    override fun getIssues(
        size: Int,
        state: String
    ): Flow<PagingData<Issue>> {
        return Pager(
            config = PagingConfig(
                pageSize = size,
                initialLoadSize = size * 2,
                enablePlaceholders = false
            ), pagingSourceFactory = { IssuePagingSource(issueDataSourceImpl, state) }
        ).flow
    }
}