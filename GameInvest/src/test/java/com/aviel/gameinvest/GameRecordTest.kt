package com.aviel.gameinvest

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class GameRecordTest{

    val gameDate = LocalDate.now()!!
    val gambleSum = 120.0
    val finishSum = 240.0
    val comment = "comment"

    lateinit var gameRecord: GameRecord

    @Before
    fun setUp() {
        gameRecord = GameRecord(gameDate, gambleSum, comment)
        gameRecord.finishSum = finishSum
    }

    @Test
    fun createNew_GettersAndSettersTest() {
        assertThat(gameRecord.date, `is`(gameDate))
        assertThat(gameRecord.gambleSum, `is`(gambleSum))
        assertThat(gameRecord.comment, `is`(comment))
        assertThat(gameRecord.finishSum, `is`(finishSum))
    }

    @Test
    fun createNew_GameRecordWithoutComment_CommentShouldBeEmptyString() {
        val gameRecord = GameRecord(gameDate, gambleSum)
        assertThat(gameRecord.comment, `is`(""))
    }

    @Test
    fun getFinishSum_noFinishSumProvided_shouldReturnNull() {
        val gameRecord = GameRecord(gameDate, gambleSum, comment)
        assertThat(gameRecord.finishSum, `is`(nullValue()))
    }

    @Test
    fun getInvestRatio_shouldReturnGambleSumDividedByFinishSum() {
        assertThat(gameRecord.getRatio(), `is`(gambleSum/finishSum))
    }
}