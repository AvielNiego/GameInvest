package com.aviel.gameinvest

class ConstantInvest(val game: GameRecord, val investGoal: Double) {

    private val invests: MutableList<Invest> = mutableListOf()

    fun addInvest(newInvest: Invest) {
        if (getAmountInvested() + newInvest.amount < investGoal)
            invests.add(newInvest)
        else
            throw InvestTooHigh()
    }

    fun getInvests(): List<Invest> {
        return invests
    }

    fun getAmountInvested(): Double {
        return invests.sumByDouble { it.amount }
    }

    data class Invest(val user: User, val amount: Double)

    class InvestTooHigh(message: String = ""): RuntimeException(message)
}
