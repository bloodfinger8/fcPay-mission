package org.fcpay.domain.fcpay.policy

class FcPayChargingPolicy {
    companion object {
        const val MINIMUM_CHARGING_PRICE = 10000L

        fun calculate(myPayAmount: Long, payAmount: Long): Long {
            return when {
                (payAmount - myPayAmount) in 0 .. MINIMUM_CHARGING_PRICE -> MINIMUM_CHARGING_PRICE
                (payAmount - myPayAmount) > MINIMUM_CHARGING_PRICE -> payAmount - myPayAmount
                else -> 0
            }
        }

        fun isMinimumChargingPrice(chargeAmount: Long): Boolean {
            return chargeAmount >= MINIMUM_CHARGING_PRICE
        }
    }
}