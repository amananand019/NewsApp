package com.devil.premises.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.devil.premises.newsapp.Article as Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}