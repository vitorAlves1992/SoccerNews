package br.testes.soccernews.data;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;
import br.testes.soccernews.App;
import br.testes.soccernews.data.local.AppDatabase;
import br.testes.soccernews.data.remote.SoccerNewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SoccerNewsRepository {

    //region Constantes
    private static final String REMOTE_API_URL = "https://digitalinnovationone.github.io/soccer-news-api/";
    private static final String LOCAL_DB_NAME = "soccer-news";
                //endregion
    private Context context = App.getInstance().getApplicationContext();

    //region Atributos: encapsulam o acesso a nossa API (Retrofit) e banco de dados local (Room).
    private SoccerNewsApi remoteApi;
    private AppDatabase localDb;

    public SoccerNewsApi getRemoteApi() {
        return remoteApi;
    }

    public AppDatabase getLocalDb() {
        return localDb;
    }
    //endregion

    //region Singleton: garante uma instância única dos atributos relacionados ao Retrofit e Room.
    private SoccerNewsRepository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SoccerNewsApi.class);

     localDb = Room.databaseBuilder(context, AppDatabase.class, LOCAL_DB_NAME).build();
    }



    private static class LazyHolder {
        private static final SoccerNewsRepository INSTANCE = new SoccerNewsRepository();
    }

    public static SoccerNewsRepository getInstance() {
        return LazyHolder.INSTANCE;
    }
    //endregion
}
