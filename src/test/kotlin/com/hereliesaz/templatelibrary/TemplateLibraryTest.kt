package com.hereliesaz.templatelibrary

import kotlin.test.Test
import kotlin.test.assertEquals

class TemplateLibraryTest {
    @Test
    fun greetingIsStable() {
        assertEquals("Hello, world.", TemplateLibrary.greeting())
    }
}
