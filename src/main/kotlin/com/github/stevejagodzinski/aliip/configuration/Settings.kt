package com.github.stevejagodzinski.aliip.configuration

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project


data class LogClassSettings(val logClass: String? = null)

@State(
    name = "com.github.stevejagodzinski.aliip.configuration.Settings",
    storages = [
        Storage(value = "/aliip.xml")
    ]
)
class Settings : PersistentStateComponent<LogClassSettings> {

    private var state = LogClassSettings()

    companion object {
        fun getInstance(project: Project): Settings {
            return ServiceManager.getService(project, Settings::class.java) ?: Settings()
        }
    }

    override fun getState(): LogClassSettings {
        return state
    }

    override fun loadState(state: LogClassSettings) {
        this.state = state
    }

    fun setLogClass(logClass: String?) {
        this.state = state.copy(logClass = logClass)
    }
}
