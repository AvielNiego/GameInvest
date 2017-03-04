package com.avielniego.gamaRecordMongoDB

import com.aviel.gameinvest.GameRecord
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class GameRecordDataParserTest {

    val gameDate: LocalDate = LocalDate.now()
    val gambleSum = 100.0
    val comment = "COMMENT"
    val finishSum = 120.0

    lateinit var gameRecord: GameRecord
    lateinit var gameRecordData: GameRecordData

    @Before
    fun setUp() {
        gameRecord = GameRecord(gameDate, gambleSum, comment)
        gameRecord.finishSum = finishSum
        gameRecordData = GameRecordData(null, gameDate, gambleSum, comment, finishSum)
    }

    @Test
    fun toData_provideGameRecord_shouldReturnTheCorrespondingGameRecordData() {
        val data: GameRecordData = GameRecordDataParser().toData(gameRecord)
        assertThat(data.date, `is`(gameDate))
        assertThat(data.comment, `is`(comment))
        assertThat(data.gambleSum, `is`(gambleSum))
        assertThat(data.finishSum, `is`(finishSum))
    }

    @Test
    fun toGameRecord_ProviderGameRecordDataFinishSum_shouldReturnTheCorrespondingGameRecordData() {
        val gameRecord: GameRecord = GameRecordDataParser().toGameRecord(gameRecordData)
        assertThat(gameRecord.date, `is`(gameDate))
        assertThat(gameRecord.comment, `is`(comment))
        assertThat(gameRecord.gambleSum, `is`(gambleSum))
        assertThat(gameRecord.finishSum, `is`(finishSum))
    }
}

