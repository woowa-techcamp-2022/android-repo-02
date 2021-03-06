package com.woowahan.domain.repository

import com.woowahan.domain.model.Message
import com.woowahan.domain.model.Notification
import com.woowahan.domain.model.Subject
import kotlinx.coroutines.flow.Flow

interface NotificationRepository<T> {
    suspend fun getNotifications(size: Int): Flow<T>
    suspend fun markNotificationAsRead(threadId: String): String
    suspend fun getSubject(
        organization: String,
        repository: String,
        type: String,
        id: String
    ): Subject
}