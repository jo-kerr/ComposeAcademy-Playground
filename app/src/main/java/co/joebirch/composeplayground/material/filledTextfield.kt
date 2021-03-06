package co.joebirch.composeplayground.material

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.input.TextFieldValue
import androidx.ui.layout.*
import androidx.ui.material.FilledTextField
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Check
import androidx.ui.material.icons.filled.Info
import co.joebirch.composeplayground.ComposableLayout

object FilledTextFieldView : ComposableLayout {

    @Composable
    override fun build() {
        VerticalScroller {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalGravity = Alignment.CenterHorizontally
            ) {
                MinimalFilledTextFieldComponent()
                PlaceholderFilledTextFieldComponent()
                IconsFilledTextFieldComponent()
            }
        }
    }

    @Composable
    fun MinimalFilledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        FilledTextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        })
    }

    @Composable
    fun PlaceholderFilledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        FilledTextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        }, placeholder = {
            Text(text = "This is a placeholder")
        })
    }

    @Composable
    fun IconsFilledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        FilledTextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        }, leadingIcon = {
            Icon(Icons.Filled.Info)
        }, trailingIcon = {
            Icon(Icons.Filled.Check)
        })
    }

    @Composable
    fun ColoredFilledTextFieldComponent() {
        val state = state { TextFieldValue(text = "Hello") }
        FilledTextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "This is a label")
        }, activeColor = Color.Black,
            inactiveColor = Color.Gray,
            errorColor = Color.Red)
    }
}