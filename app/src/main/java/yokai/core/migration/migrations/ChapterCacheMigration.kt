package yokai.core.migration.migrations

import eu.kanade.tachiyomi.App
import yokai.core.migration.Migration
import yokai.core.migration.MigrationContext
import java.io.File

/**
 * Delete external chapter cache dir.
 */
class ChapterCacheMigration : Migration {
    override val version: Float = 26f

    override suspend fun invoke(migrationContext: MigrationContext): Boolean {
        val context: App = migrationContext.get() ?: return false
        val extCache = context.externalCacheDir
        if (extCache != null) {
            val chapterCache = File(extCache, "chapter_disk_cache")
            if (chapterCache.exists()) {
                chapterCache.deleteRecursively()
            }
        }
        return true
    }
}
