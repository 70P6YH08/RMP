package com.example.clicker31

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    var score by mutableStateOf(0.0)
    var upgrades = mutableStateMapOf(
        UpgradeType.AutoClick to Upgrade(
            type = UpgradeType.AutoClick,
            baseCost = 10.0,
            costMultiplier = 1.5,
            initialValue = -1.0,
            baseValue = 1.0,
            valueMultiplier = 1.2
        ),
        UpgradeType.ClickMultiplier to Upgrade(
            type = UpgradeType.ClickMultiplier,
            baseCost = 10.0,
            costMultiplier = 1.5,
            initialValue = 0.0,
            baseValue = 1.0,
            valueMultiplier = 13.05
        ),
        UpgradeType.OfflineIncome to Upgrade(
            type = UpgradeType.OfflineIncome,
            baseCost = 10.0,
            costMultiplier = 1.5,
            initialValue = -1.0,
            baseValue = 1.0,
            valueMultiplier = 10.0
        ),
    )
    fun onTap(){
        score+=upgrades[UpgradeType.ClickMultiplier]?.currentValue() ?: 1.0
    }

    fun onAutoClick(){
        score+= upgrades[UpgradeType.AutoClick]?.currentValue() ?: 0.0
    }

    fun onUpgrade(upgrade: Upgrade){
        if (score >= upgrade.currentCost()){
            score-=upgrade.currentCost()
            upgrades[upgrade.type] = upgrade.next()
        }
    }
}