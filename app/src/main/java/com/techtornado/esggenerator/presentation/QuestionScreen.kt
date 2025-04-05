package com.techtornado.esggenerator.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun QuestionScreen(
    modifier: Modifier = Modifier,
    questionAnswer: Answer = Answer("Question", ""),
    onDone: (answer: Answer) -> Unit = {}
) {
    var answer by rememberSaveable(questionAnswer) {
        mutableStateOf(questionAnswer.answer)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .imePadding()
    ) {
        Text(questionAnswer.question)
        TextField(
            value = answer,
            onValueChange = { answer = it },
            minLines = 10,
            modifier = Modifier.fillMaxWidth()
        )
        FloatingActionButton (
            onClick = {
                onDone(Answer(question = questionAnswer.question, answer))
                      },
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(Icons.Default.Done, "Done")
        }
    }
}

@Preview
@Composable
fun QuestionPreview() {
    QuestionScreen()
}