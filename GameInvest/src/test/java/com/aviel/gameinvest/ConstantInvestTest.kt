package com.aviel.gameinvest

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.time.LocalDate


class ConstantInvestTest {

    private lateinit var constInvest: ConstantInvest
    private val investGoal = 300.0
    private val gambleSum = 1000.0
    private val gameRecord = GameRecord(LocalDate.now(), gambleSum)

    @Before
    fun setUp() {
        constInvest = ConstantInvest(gameRecord, investGoal)
    }

    @Test
    fun createNew_GettersAndSettersTest() {
        assertThat(constInvest.game, `is`(gameRecord))
        assertThat(constInvest.investGoal, `is`(investGoal))
    }

    @Test
    fun getInvests_noInvestsAdded_shouldReturnAnEmptyList() {
        assertThat(constInvest.getInvests(), `is`(emptyList()))
    }

    @Test
    fun getInvests_addInvestWithLowerInvestAmountThenGoal_shouldReturnTheInvestAdded() {
        val lowerInvestAmountThenGoal = investGoal - (investGoal/2)
        val invest = ConstantInvest.Invest(User(1), lowerInvestAmountThenGoal)
        constInvest.addInvest(invest)
        assertTrue(invest in constInvest.getInvests())
    }

    @Test(expected = ConstantInvest.InvestTooHigh::class)
    fun addInvest_addInvestHigherThenInvestGoal_shouldTrowInvestTooHighException() {
        val higherInvestAmountThenGoal = investGoal + 50.0
        val tooHighInvest = ConstantInvest.Invest(User(1), higherInvestAmountThenGoal)
        constInvest.addInvest(tooHighInvest)
    }

    @Test
    fun addInvest_addCoupleOfInvests_TotalInvestAmountLowerThenGoal_shouldNotThrowException() {
        val lowerInvestAmountThenGoal = investGoal * 0.25
        val invest1 = ConstantInvest.Invest(User(1), lowerInvestAmountThenGoal)
        val invest2 = ConstantInvest.Invest(User(1), lowerInvestAmountThenGoal)
        constInvest.addInvest(invest1)
        constInvest.addInvest(invest2)
        assertTrue(constInvest.getInvests().containsAll(listOf(invest1, invest2)))
    }

    @Test(expected = ConstantInvest.InvestTooHigh::class)
    fun addInvest_addInvestsLowerThenGoalButTotalAmountHigherThemGoal_shouldTrowInvestTooHigh() {
        val lowerInvestAmountThenGoal = investGoal * 0.75
        val invest1 = ConstantInvest.Invest(User(1), lowerInvestAmountThenGoal)
        val invest2 = ConstantInvest.Invest(User(1), lowerInvestAmountThenGoal)
        constInvest.addInvest(invest1)
        constInvest.addInvest(invest2)
    }

    @Test
    fun getAmountInvested_investsAdded_shouldReturnTheTotalAmountInvested() {
        val lowerInvestAmountThenGoal = investGoal * 0.25
        val invest1 = ConstantInvest.Invest(User(1), lowerInvestAmountThenGoal)
        val invest2 = ConstantInvest.Invest(User(1), lowerInvestAmountThenGoal)
        constInvest.addInvest(invest1)
        constInvest.addInvest(invest2)
        assertThat(constInvest.getAmountInvested(), `is`(lowerInvestAmountThenGoal + lowerInvestAmountThenGoal))
    }
}

