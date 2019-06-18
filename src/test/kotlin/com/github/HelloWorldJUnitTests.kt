package com.github

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class HelloWorldJUnitTests {

    @Test
    fun `my first test`(){
        HelloWorld().greetings() shouldBe "Hello World!!!"
    }

    @Test
    fun `mock greetings test`(){
        val car = mockk<HelloWorld>()
        every { car.greetings() } returns "How are you?"
        car.greetings() shouldBe "How are you?"
        verify { car.greetings() }
    }
}
