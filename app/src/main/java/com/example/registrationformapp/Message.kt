package com.example.registrationformapp

import java.io.Serializable

data class Message(
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val phoneNumber: String,
    val title: String?
): Serializable {

}