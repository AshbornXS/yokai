package yokai.core.migration.migrations

import androidx.core.content.edit
import androidx.preference.PreferenceManager
import eu.kanade.tachiyomi.App
import yokai.core.migration.Migration
import yokai.core.migration.MigrationContext

class RotationTypeMigration : Migration {
    override val version: Float = 73f

    override suspend fun invoke(migrationContext: MigrationContext): Boolean {
        val context: App = migrationContext.get() ?: return false
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        if (prefs.contains("pref_rotation_type_key")) {
            prefs.edit {
                putInt("pref_rotation_type_key", 1)
            }
        }
        return true
    }
}
