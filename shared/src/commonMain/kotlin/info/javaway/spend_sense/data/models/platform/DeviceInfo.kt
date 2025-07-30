@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package info.javaway.spend_sense.data.models.platform

expect class DeviceInfo constructor() {
    val osName: String
    val osVersion: String
    val model: String
    val cpu: String
    val screenWidth: Int
    val screenHeight: Int
    val screenDestiny: Int

    fun getSummary() : String
}