package com.woowahan.data.entity

import com.google.gson.annotations.SerializedName
import com.woowahan.domain.model.User

data class UserData(
    val login: String,
    val name: String,
    @SerializedName("avatar_url")
    val avatar: String,
    val company: String?,
    val location: String?,
    val blog: String?,
    val email: String?,
    val followers: Int,
    val following: Int,
    @SerializedName("public_repos")
    val repositories: Int,
)

fun UserData.toModel() = User(
    login,
    name,
    avatar,
    company,
    location,
    blog,
    email,
    followers,
    following,
    repositories,
)