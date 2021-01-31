package com.example.myapplication.model

import java.io.Serializable

data class Comment(
    var comment: String?,
    var creation_date: CreationDate?,
    var id: String?,
    var user: String?
): Serializable