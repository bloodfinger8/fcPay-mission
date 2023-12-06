package org.fcpay.domain.firmbanking

enum class FirmBankingType(val description: String) {
    PAY_TO_ACCOUNT("고객의 페이 머니를 외부 계좌 송금"),
    PAY_CHARGING("고객의 연결된 계좌로 부터 페이 머니 충전"),
}