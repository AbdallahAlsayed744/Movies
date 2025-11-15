package com.hyperdesign.moviesapp.common.data.model.exception

import com.hyperdesign.moviesapp.common.domain.model.exception.IErrorKeyEnum
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ErrorKeyEnum : IErrorKeyEnum {
    @SerialName("phone.number")
    PHONE_NUMBER,
    @SerialName("password")
    PASSWORD,
    @SerialName("country_code")
    COUNTRY_CODE,
    @SerialName("email")
    EMAIL,
    @SerialName("first_name")
    FIRST_NAME,
    @SerialName("last_name")
    LAST_NAME,
    @SerialName("middle_name")
    MIDDLE_NAME,
    @SerialName("birth_date")
    BIRTH_DATE,
    @SerialName("image")
    IMAGE,
    UNKNOWN;
}