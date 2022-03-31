/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.app.rest;

import ${package}.app.dto.PaymentRequest;
import ${package}.app.service.PaymentService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Objects;

@ApplicationScoped
@Path("/v1/payments")
public class PaymentResource {

    @Inject
    private PaymentService paymentService;

    /**
     *
     * @param request
     * @return
     */
    @POST
    @Path("/save")
    Uni<Response> save(final PaymentRequest request){
        return paymentService.save(request)
                .onItem().transform(response -> Response.ok(response))
                .onItem().transform(Response.ResponseBuilder::build);
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    Uni<Response> getById(@PathParam("id") Long id){
        return paymentService.getById(id)
                .onItem().transform(response -> Response.ok(response))
                .onItem().transform(Response.ResponseBuilder::build);
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/all")
    Uni<Response> getAll(){
        return paymentService.getAll()
                .onItem().transform(response -> Response.ok(response))
                .onItem().transform(Response.ResponseBuilder::build);
    }

    /**
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("{id}")
    Uni<Response> delete(@PathParam("id") Long id){
        return paymentService.delete(id)
                .onItem().transform(response -> Response.ok(response))
                .onItem().transform(Response.ResponseBuilder::build);
    }

    /**
     *
     * @param id
     * @param request
     * @return
     */
    @PUT
    @Path("{id}")
    public Uni<Response> update(@PathParam("id") Long id, PaymentRequest request) {
        Objects.nonNull(request);

        return paymentService.update(id, request)
                .onItem().ifNotNull().transform(entity -> Response.ok(entity).build())
                .onItem().ifNull().continueWith(Response.ok().status(Response.Status.NOT_FOUND)::build);
    }
}
