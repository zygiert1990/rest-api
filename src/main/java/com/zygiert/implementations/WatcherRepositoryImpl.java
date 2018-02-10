package com.zygiert.implementations;

import com.zygiert.domain.Watcher;
import com.zygiert.repositories.WatcherRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WatcherRepositoryImpl implements WatcherRepository {
    private List<Watcher> watchers;

    public WatcherRepositoryImpl() {
        watchers = new ArrayList<Watcher>();
    }

    public List<Watcher> getWatchers() {
        return watchers;
    }

    @Override
    public List<Watcher> findAll() {
        return this.watchers;
    }

    @Override
    public Watcher findOne(long watcherId) {
        int i = 0;
        while ((watchers.get(i).getWatcherId() != watcherId) &&
                (i < watchers.size())) {
            i++;
        }
        if (watchers.get(i).getWatcherId() != watcherId) return null;
        else return watchers.get(i);
    }

    @Override
    public void save(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public boolean delete(Watcher watcher) {
        return watchers.remove(watcher);
    }

    @Override
    public void setWatchers(List<Watcher> watchers) {
        this.watchers = watchers;
    }


}
