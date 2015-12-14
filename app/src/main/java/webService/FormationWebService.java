package webService;

import android.content.Context;

import org.apache.http.conn.ConnectTimeoutException;

import java.io.FileNotFoundException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;

/**
 * Created by arafla on 11/12/2015.
 */
public class FormationWebService {

    public String getResponseForUrl(String urlString, Context context)
            throws ConnectTimeoutException, SocketTimeoutException {
        return "";
    }

    public String getResponse(String urlString, Context context)
            throws ConnectTimeoutException, SocketTimeoutException, FileNotFoundException {
        return "";
    }

    public static String postRequestForUrl(String urlString, Map<String, Object> params,
                                           Context context) throws ConnectTimeoutException, SocketTimeoutException {
        return "";
    }

    public static String putRequestForUrl(String urlString, Map<String, Object> params,
                                          Context context) throws ConnectTimeoutException, SocketTimeoutException {
        return "";
    }

    private static String request(String urlString, Map<String, Object> params, String method,
                                  Context context) throws ConnectTimeoutException, SocketTimeoutException {
        return "";
    }

    public void sendErrorWS(Context context, List err, String url, String method,
                            Map<String, Object> requestParams) {
    }

    private static String getBasicAuthString(Context context) {
        return "";
    }
}

