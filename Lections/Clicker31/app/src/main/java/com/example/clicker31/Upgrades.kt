package com.example.clicker31

sealed class UpgradeType{
    object ClickMultiplier : UpgradeType()
    object AutoClick : UpgradeType()
    object OfflineIncome : UpgradeType()
}

class Upgrades(
    type: UpgradeType,
    level: Int = 0,
    initialValue : Double,
    baseValue : Double,
    valueMultiplier : Double,
    baseCost : Double,
    constMultiplier : Double
){

}