package com.test.test.repository

import com.test.test.model.Test
import org.springframework.data.mongodb.repository.MongoRepository

interface PoemRepo : MongoRepository<Test, Int>