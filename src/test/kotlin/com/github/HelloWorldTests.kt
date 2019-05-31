package com.github

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class HelloWorldTests : StringSpec() {


    init {
        "my first test" {
            HelloWorld().greetings() shouldBe "Hello World!!!"

        }
    }
}