package com.techtornado.esggenerator.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

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
        questionAnswer = mockAnswers[questionIndex],
        onDone = {
            answers.add(it)
            if (questionIndex >= mockAnswers.lastIndex) {
                onDone(answers.toList())
            } else {
                questionIndex++
            }
        }
    )
}