package com.app.ds.api;

import com.app.ds.QuoteManager;
import com.app.ds.beans.MyBean;
import com.app.ds.beans.Quote;
import com.app.ds.beans.Status;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * Created by deepak.barr on 24/2/15.
 */


@Api(name = "quoteApi",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "quote",
                ownerName = "quote",
                packagePath="/quote"))
public class QuoteAPI {

        @ApiMethod(name = "getQuote", httpMethod = ApiMethod.HttpMethod.GET)
    public Quote getQuote() {
        String quote= QuoteManager.INSTANCE.getRandomQuote();
        return new Quote(quote);
    }
    @ApiMethod(name = "sendQuote", httpMethod = ApiMethod.HttpMethod.GET)
    public Status sendQuote(@Named("quote") String quote) {
        String status=QuoteManager.INSTANCE.insertQuote(quote);
        return new Status(status);
    }
}
