package com.tresor.app.db

import org.jetbrains.exposed.sql.Database

object Db {
    val tresor: Database by lazy {
        Database.connect(url = "jdbc:postgresql://localhost:5432/tresor",
                driver = "org.postgresql.Driver",
                user = "tresor",
                password = "tresor"
        )
    }
}