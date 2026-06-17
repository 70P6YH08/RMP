package com.example.test

import androidx.compose.material3.Text
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class CounterTest {
    @get:Rule
//    val composeRule = createAndroidComposeRule<MainActivity>()
    val composeRule = createComposeRule()

    @Test
    fun textDisplayed(){
        composeRule.setContent {
            Text("Hello")
        }

        composeRule
            .onNodeWithText("Hello")
            .assertExists()
    }

    @Test
    fun counterIncreaseValueOnClick(){
        composeRule.setContent {
            Counter()
        }

        composeRule
            .onNodeWithTag("counterLabel", useUnmergedTree = true)
            .assertExists()
            .assertTextEquals("0")

        composeRule
            .onNodeWithTag("counterButton")
            .assertExists()
            .performClick()

        composeRule
            .onNodeWithTag("counterLabel", useUnmergedTree = true)
            .assertExists()
            .assertTextEquals("1")

    }
}