package com.test.test.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("Test")
data class Test (
    @Id
    var num : Int ,

    var name : String
)