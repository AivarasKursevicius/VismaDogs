package com.aivaras.dogs.vismadogs

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.aivaras.dogs.vismadogs.utils.DogsJsonParser
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DogsJsonParserTest {

    @Test
    fun testParseJson() {
        val instrumentationCtx = InstrumentationRegistry.getContext()
        val dogUrls = DogsJsonParser.parse(instrumentationCtx)
        assertThat(dogUrls.urls.size, `is`(1000))
    }
}
