package io.rsocket.expect

import io.rsocket.frame.shared.*
import strikt.api.*
import strikt.assertions.*

fun <T : ResumeToken?> Assertion.Builder<T>.isEqualToResumeToken(expected: ResumeToken?): Assertion.Builder<T> = apply {
    get("length") { this?.length }.isEqualTo(expected?.length)
    get("token") { this?.token }.isEqualToBuffer(expected?.token)
}
