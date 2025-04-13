package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val stepContextCache = mutableMapOf<TestContext<*>, Steps>()
val TestContext<*>.steps: Steps
    get() = stepContextCache.getOrPut(this) { Steps(this) }

package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

val <T> TestContext<T>.namedSteps: NamedSteps
    get() = NamedSteps(this)