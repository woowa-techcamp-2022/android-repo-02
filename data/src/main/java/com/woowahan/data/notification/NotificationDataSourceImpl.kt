package com.woowahan.data.notification

import com.woowahan.data.base.BaseDataSource
import com.woowahan.data.entity.toModel
import com.woowahan.domain.model.Message
import com.woowahan.domain.model.Notification

class NotificationDataSourceImpl(override val service: NotificationService) :
    BaseDataSource<NotificationService>() {
    suspend fun getNotifications(page: Int, size: Int): List<Notification> =
        getData(service.getNotifications(page, size)).map {
            it.toModel()
        }

    suspend fun markNotificationAsRead(threadId: String) =
        getMessage(service.markNotificationAsRead(threadId))

    suspend fun getSubject(organization: String, repository: String, type: String, id: String) =
        getData(service.getSubject(organization, repository, type, id)).toModel()
}