package com.intendia.gwt.autorest.example.client;

import com.intendia.gwt.autorest.client.AutoRestGwt;
import com.intendia.gwt.autorest.client.ResourceVisitor;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import rx.Single;

@AutoRestGwt
@Path("single")
public interface SingleService {

    @PUT Single<Void> ping();

    @GET Single<Greeting> get();

    @POST Single<Greeting> put(Greeting name);

    @com.google.gwt.core.shared.GwtIncompatible Response gwtIncompatible();

    @com.google.common.annotations.GwtIncompatible("serverOnly") Response guavaIncompatible();

    @POST Single<Greeting> postForm(@FormParam("name") String name);

    class Factory {
        public static SingleService create(ResourceVisitor.Supplier factory) {
            return new SingleService_RestServiceModel(() -> factory.get().header("mode", "single"));
        }
    }
}
