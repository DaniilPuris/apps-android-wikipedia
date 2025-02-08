package org.wikipedia.homeworks.homework04

import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Schedule {

    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(
                                timeFormatter
                            )
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }

    operator fun invoke(function: Schedule.() -> Unit) {
        function()
    } 

    private var currentDay: Days? = null

    internal fun setCurrentDay(day: Days) {
        currentDay = day
    }

    fun addSchedule(startTime: LocalTime, endTime: LocalTime, lesson: String) {
        currentDay?.let { day ->
            addSchedule(day, ScheduleEntity(lesson, startTime, endTime))
        }
    }

    class TimeRange(val start: String, val end: String)

    operator fun String.rangeTo(other: String) = TimeRange(this, other)

    infix fun TimeRange.schedule(lesson: String) {
        val startHour = start.substring(0, 2).toInt()
        val startMinute = start.substring(3, 5).toInt()
        val endHour = end.substring(0, 2).toInt()
        val endMinute = end.substring(3, 5).toInt()
        
        val startTime = LocalTime.of(startHour, startMinute)
        val endTime = LocalTime.of(endHour, endMinute)
        addSchedule(startTime, endTime, lesson)
    }
}

internal fun Schedule.monday(block: Schedule.() -> Unit) {
    setCurrentDay(Days.MONDAY)
    block()
}

internal fun Schedule.tuesday(block: Schedule.() -> Unit) {
    setCurrentDay(Days.TUESDAY)
    block()
}

internal fun Schedule.wednesday(block: Schedule.() -> Unit) {
    setCurrentDay(Days.WEDNESDAY)
    block()
}

internal fun Schedule.thursday(block: Schedule.() -> Unit) {
    setCurrentDay(Days.THURSDAY)
    block()
}

internal fun Schedule.friday(block: Schedule.() -> Unit) {
    setCurrentDay(Days.FRIDAY)
    block()
}

internal fun Schedule.saturday(block: Schedule.() -> Unit) {
    setCurrentDay(Days.SATURDAY)
    block()
}

internal fun Schedule.sunday(block: Schedule.() -> Unit) {
    setCurrentDay(Days.SUNDAY)
    block()
}

fun main() {

    val schedule = Schedule()

// Так добавляется расписание без DSL
// schedule.addSchedule(MONDAY, ScheduleEntity("Biology", LocalTime.of(10, 30), LocalTime.of(11, 10)))
// schedule.addSchedule(MONDAY, ScheduleEntity("Chemistry", LocalTime.of(11, 15), LocalTime.of(11, 55)))

// Так добавляется расписание с использованием DSL
    schedule {

        monday {
            "10:30".."11:10" schedule "Biology"
            "11:15".."11:55" schedule "Chemistry"
            "09:00".."09:40" schedule "Mathematics"
            "09:45".."10:25" schedule "History"
        }

        tuesday {
            "09:00".."09:40" schedule "English"
            "09:45".."10:25" schedule "Geography"
            "11:15".."11:55" schedule "Art"
            "10:30".."11:10" schedule "Physics"
        }

        wednesday {
            "11:15".."11:55" schedule "Biology"
            "09:00".."09:40" schedule "Literature"
            "10:30".."11:10" schedule "History"
            "09:45".."10:25" schedule "Mathematics"
        }

        thursday {
            "11:15".."11:55" schedule "Physics"
        }
    }
}