package com.woowahan.data.notification

import com.woowahan.data.entity.NotificationData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface NotificationService {
    @GET("/notifications")
    @Headers("Accept: application/vnd.github+json")
    suspend fun getNotifications(): Response<List<NotificationData>>
}