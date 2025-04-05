package com.techtornado.erggenerator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

val questions = listOf(
    "How many employees does the company have?",
    "How much waste does the company produce in a year?",
    "How much energy does the company produce in a year?"
)

@Composable
fun QuestionareScreen(
    modifier: Modifier = Modifier,
    onDone: (List<Answer>) -> Unit = {}
) {
    val answers = remember {
        mutableStateListOf<Answer>()
    }

    var questionIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    QuestionScreen(
        modifier = modifier,
        question = questions[questionIndex],
        onDone = {
            answers.add(Answer(questions[questionIndex], it))
            if (questionIndex >= questions.lastIndex) {
                onDone(answers.toList())
            } else {
                questionIndex++
            }
        }
    )
}