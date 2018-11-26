package com.tresor.app.db

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction

class DbMigration(private val db: Database) {
    fun migrate() {
        transaction(db) {
            val version = getCurrentDbVersion(this)
        }
    }

    private fun getCurrentDbVersion(tx: Transaction): Int {
        tx.exec("""
            CREATE TABLE IF NOT EXISTS meta (
                key VARCHAR(50) PRIMARY KEY,
                value integer NOT NULL DEFAULT 0
		    );
        """.trimIndent())

        tx.exec("""
            INSERT INTO meta (key, value)
                VALUES ('db-version', 0)
                ON CONFLICT DO NOTHING
        """.trimIndent())

        return tx.exec("""
            SELECT value FROM meta WHERE key = 'db-version'
        """.trimIndent()) {
            it.next()
            return@exec if (it.first()) {
                it.getInt("value") ?: 0
            } else {
                0
            }
        }!!
    }
}