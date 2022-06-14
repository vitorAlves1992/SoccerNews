package br.testes.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.testes.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();


        List<News> news = new ArrayList<>();
        news.add(new News("Corinthians ",  "descrição1"));
        news.add(new News("Palmeiras ",  "descrição2"));
        news.add(new News("Santos ",  "descrição3"));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}