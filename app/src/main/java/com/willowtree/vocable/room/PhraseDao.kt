package com.willowtree.vocable.room

import androidx.room.*

@Dao
interface PhraseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhrase(phrase: Phrase)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhrases(vararg phrases: Phrase)

    @Delete
    suspend fun deletePhrase(phrase: Phrase)

    @Query("SELECT * FROM Phrase WHERE is_user_generated == 1")
    suspend fun getUserGeneratedPhrases(): List<Phrase>

    @Query("SELECT * FROM Phrase WHERE category_id == :categoryId")
    suspend fun getPhrasesByCategory(categoryId: Long): List<Phrase>

    @Update
    suspend fun updatePhrase(phrase: Phrase)

}