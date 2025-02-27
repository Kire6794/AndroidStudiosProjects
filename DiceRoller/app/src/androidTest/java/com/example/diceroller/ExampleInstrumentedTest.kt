package com.example.diceroller

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.diceroller.ui.theme.DiceRollerTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun testDiceRollButtonClick(){
        composeTestRule.setContent {
            DiceRollerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceRoller(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        //Comprueba que haya una imagen con contenido 1
        composeTestRule.onNodeWithContentDescription("1").assertExists()
        //comprueba que haya un boton y apreita el boton
        composeTestRule.onNodeWithText("Roll").performClick()
        //Espera un tiempo
        composeTestRule.waitForIdle()
        //valida que salga una imagen con valor de 1 a 6
        val anyValidDiceFaceExists = (1..6).any{
            composeTestRule.onNodeWithContentDescription(it.toString()).assertExists()
            true
        }
        assert(anyValidDiceFaceExists)
    }
}