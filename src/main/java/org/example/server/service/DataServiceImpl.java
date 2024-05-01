package org.example.server.service;

import jakarta.jws.WebService;
import org.example.server.repository.DataRepository;

import java.util.concurrent.atomic.AtomicInteger;

// Імплементація інтерфейсу Web-сервісу.
@WebService(endpointInterface = "org.example.server.service.DataService")
public class DataServiceImpl implements DataService {

    private static final String GET_DATA_KEY = "get";

    @Override
    public String getData(String req) {
        return ">> Server response:\n" + fetchData(req);
    }

    private String fetchData(String req) {
        if (req.equals(GET_DATA_KEY)) {
            AtomicInteger count = new AtomicInteger(0);
            StringBuilder stringBuilder = new StringBuilder();
            new DataRepository().fetchData().forEach(value ->
                    stringBuilder.append(count.incrementAndGet())
                    .append(") ")
                    .append(value.toString())
            );
            return stringBuilder.toString();
        } else return "No data.";
    }
}
