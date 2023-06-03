package com.example.registrationformapp

import java.io.Serializable

data class User(
    val title: String,
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val phoneNumber: String,
    val password: String
): Serializable {

}