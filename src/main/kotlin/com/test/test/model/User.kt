package com.test.test.model
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
class User (
    @Id
    var id:Int,
    @Field
    var firstName:String,
    @Field
    var lastName :String,

) {
    override fun toString(): String {
        return "User(id=$id, firstName='$firstName', lastName='$lastName')"
    }
}