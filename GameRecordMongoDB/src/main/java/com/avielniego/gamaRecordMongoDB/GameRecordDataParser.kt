package com.avielniego.gamaRecordMongoDB

import com.aviel.gameinvest.GameRecord

class GameRecordDataParser {
    fun toData(gameRecord: GameRecord): GameRecordData {
        return GameRecordData(null, gameRecord.date, gameRecord.gambleSum, gameRecord.comment, gameRecord.finishSum)
    }

    fun toGameRecord(gameRecordData: GameRecordData): GameRecord {
        val gameRecord = GameRecord(gameRecordData.date, gameRecordData.gambleSum, gameRecordData.comment)
        gameRecord.finishSum = gameRecordData.finishSum
        return gameRecord
    }

}