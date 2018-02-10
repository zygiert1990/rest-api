package com.zygiert.repositories;

import com.zygiert.domain.Watcher;

import java.util.List;

public interface WatcherRepository {
    List<Watcher> findAll();

    Watcher findOne(long watcherId);

    void save(Watcher watcher);

    boolean delete(Watcher watcher);

    void setWatchers(List<Watcher> watchers);

}
