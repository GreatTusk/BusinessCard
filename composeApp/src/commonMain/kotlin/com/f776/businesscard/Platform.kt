package com.f776.businesscard

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform