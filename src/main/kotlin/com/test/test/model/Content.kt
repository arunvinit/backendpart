package com.test.test.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("Content")
data class Content (
    @Id
    var id : Int ,
    var isShayri:Boolean,
    var isStory:Boolean,
    var isPoem:Boolean,
    var content : String
)