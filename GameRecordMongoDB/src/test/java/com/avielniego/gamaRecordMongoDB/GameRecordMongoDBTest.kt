package com.avielniego.gamaRecordMongoDB

import org.junit.Test

class GameRecordMongoDBTest {

    @Test
    fun connect() {
        GameRecordMongoDB().connect("avielniego", "Python46")
    }

}