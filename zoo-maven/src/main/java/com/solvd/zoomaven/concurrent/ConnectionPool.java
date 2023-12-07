package com.solvd.zoomaven.concurrent;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {

    private final Queue<Connection> q;
    private final int capacity;
    private static volatile ConnectionPool connectionPoolInstance;

    private ConnectionPool(int capacity) {
        q = new LinkedList<>();
        this.capacity = capacity;
    }

    public static ConnectionPool getConnectionPool(int capacity) {
        if (connectionPoolInstance == null) {
            synchronized (ConnectionPool.class) {
                if (connectionPoolInstance == null)
                    connectionPoolInstance = new ConnectionPool(capacity);
            }
        }
        return connectionPoolInstance;
    }

    public void releaseConnection(Connection n) {
        synchronized (q) {
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            q.add(n);
            q.notifyAll();
        }
    }

    public Connection getConnection() {
        synchronized (q) {
            while (q.isEmpty()) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Connection element = q.poll();
            q.notifyAll();
            return element;
        }
    }

}
