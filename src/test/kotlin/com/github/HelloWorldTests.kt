package com.github

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class HelloWorldTests : StringSpec() {


    init {
        "my first test" {
            HelloWorld().greetings() shouldBe "Hello World!!!"
        }

        "mock greetings test" {
            val car = mockk<HelloWorld>()
            every { car.greetings() } returns "How are you?"
            car.greetings() shouldBe "How are you?"
            verify { car.greetings() }
        }
    }
}