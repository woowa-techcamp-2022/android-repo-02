package com.woowahan.domain.repository

import com.woowahan.domain.model.Notification

interface NotificationRepository {
    suspend fun getNotifications(): List<Notification>
}