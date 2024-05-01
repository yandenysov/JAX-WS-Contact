package org.example.client.api;

import jakarta.xml.ws.Service;
import org.example.client.utils.Constants;
import org.example.server.service.DataService;

import javax.xml.namespace.QName;
import java.net.URI;
import java.net.URL;

public class DataClient {

    public String runClient(String data) throws Exception {
        URL url = URI.create(Constants.WSDL_URL).toURL();
//        URL url = new URL(Constants.URL);

        QName qname = new QName(
                // Service URI (INFO/img_02.png)
                "http://service.server.example.org/",
                // Service Implementation (INFO/img_02.png)
                "DataServiceImplService"
        );
        Service service = Service.create(url, qname);
        DataService dataService = service.getPort(DataService.class);
        return dataService.getData(data);
    }
}
