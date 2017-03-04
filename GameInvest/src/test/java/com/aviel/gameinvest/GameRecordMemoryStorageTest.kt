package com.aviel.gameinvest

import com.aviel.gameinvest.gameRecordGateaway.GameRecordMemoryStorage
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class GameRecordMemoryStorageTest {

    lateinit var storage: GameRecordMemoryStorage

    @Before
    fun setUp() {
        storage = GameRecordMemoryStorage()
    }

    @Test
    fun findAll_noGamesAdded_shouldReturnEmptyList() {
        assertThat(storage.findAll(), `is`(emptyList()))
    }

    @Test
    fun addGameRecord_addNewGameRecord_shouldReturnTheGameRecordWhenCalling_findAll() {
        val gameRecord = GameRecord(LocalDate.now(), 100.0)
        storage.addGameRecord(gameRecord)
        assertTrue(gameRecord in storage.findAll())
    }

    @Test
    fun addGameRecord_addCoupleOfGameRecords_shouldReturnAllOfThemWith_findAll() {
        val gameRecord1 = GameRecord(LocalDate.now(), 100.0)
        val gameRecord2 = GameRecord(LocalDate.now(), 110.0)
        val gameRecord3 = GameRecord(LocalDate.now(), 120.0)
        storage.addGameRecord(gameRecord1)
        storage.addGameRecord(gameRecord2)
        storage.addGameRecord(gameRecord3)
        assertTrue(storage.findAll().containsAll(listOf(gameRecord1, gameRecord2, gameRecord3)))
    }

    @Test
    fun deleteGameRecord_deleteNonExistsGameRecord_shouldNotThrowException() {
        storage.deleteGameRecord(GameRecord(LocalDate.now(), 100.0))
    }

    @Test
    fun deleteGameRecord_deleteExistingGameRecord_shouldNotReturnHimWhenCalling_findAll() {
        val gameRecord = GameRecord(LocalDate.now(), 100.0)
        storage.addGameRecord(gameRecord)
        assertTrue(gameRecord in storage.findAll())
        storage.deleteGameRecord(gameRecord)
        assertTrue(gameRecord !in storage.findAll())
    }
}

