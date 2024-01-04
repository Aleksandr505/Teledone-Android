package com.example.teledoneandroid.data

import com.example.teledoneandroid.R
import com.example.teledoneandroid.model.Task

class Datasource() {
    fun loadTasks(): List<Task> {
        return listOf(
            Task(R.string.task1),
            Task(R.string.task2),
            Task(R.string.task3),
            Task(R.string.task4))
    }
}