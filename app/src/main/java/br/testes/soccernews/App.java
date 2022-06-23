package br.testes.soccernews;

import android.app.Application;

/**

 *Pesquisar injeção de dependências (como o Dagger ou o Hilt) e aplicar no projeto
 *
 * @see <a href="https://stackoverflow.com/a/14057777/3072570">Android Singleton with Global Context</a>
 */


public class App extends Application {




    private static App instance;

    public static App getInstance() {

        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}