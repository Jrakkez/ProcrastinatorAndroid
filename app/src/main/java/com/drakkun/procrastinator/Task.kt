package com.drakkun.procrastinator

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by Samantha on 8/10/2017.
 */

@RealmClass
open class Task : RealmObject() {

    @PrimaryKey
    lateinit var dateCreated: String
    lateinit var taskName: String
    lateinit var description: String
    lateinit var deadline: String

    val timeUntilDue: Double
        get() {
            //todo calculate time left to complete task
            return 0.0
        }
}