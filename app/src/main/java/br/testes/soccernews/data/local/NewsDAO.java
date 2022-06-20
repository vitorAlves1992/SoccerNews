package br.testes.soccernews.data.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;
import br.testes.soccernews.domain.News;

@Dao
public interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(News news);

    @Query("SELECT * FROM news WHERE favorite = 1")
    List<News> loadFavoriteNews();
}