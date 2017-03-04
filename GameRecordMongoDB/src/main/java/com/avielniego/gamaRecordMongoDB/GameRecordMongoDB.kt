package com.avielniego.gamaRecordMongoDB

import com.aviel.gameinvest.GameRecord
import com.aviel.gameinvest.gameRecordGateaway.GameRecordGateway
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoCollection
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

class GameRecordMongoDB: GameRecordGateway {

    private val DB_NAME = "game_records"

    private var client: MongoClient? = null
    private var collection: MongoCollection<GameRecordData>? = null

    fun connect(username: String, password: String) {
        val uri = "mongodb://$username:$password@ds115110.mlab.com:15110/$DB_NAME"
        client = KMongo.createClient(MongoClientURI(uri))
        collection = client!!.getDatabase(DB_NAME).getCollection<GameRecordData>()
    }

    fun disconnect() {
        client?.close()
    }

    override fun addGameRecord(gameRecord: GameRecord) {
        val data = GameRecordData(null, gameRecord.date, gameRecord.gambleSum, gameRecord.comment, gameRecord.finishSum)
        collection?.insertOne(data) ?: throw NotConnectedException()
    }

    override fun deleteGameRecord(gameRecord: GameRecord) {
        collection ?: throw NotConnectedException()
    }

    override fun findAll(): List<GameRecord> {
        val result: MutableList<GameRecord> = mutableListOf()
        collection?.find()?.forEach { result.add(gameRecordDateToGameRecord(it)) } ?: throw NotConnectedException()
        return result
    }

    private fun gameRecordDateToGameRecord(data: GameRecordData): GameRecord {
        val gameRecord = GameRecord(data.date, data.gambleSum, data.comment)
        gameRecord.finishSum = data.finishSum
        return gameRecord
    }

    class NotConnectedException: RuntimeException()
}

