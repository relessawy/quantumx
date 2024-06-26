package com.packt.mastering.openshift.example;

import java.util.List;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/experiments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExperimentResource {

    @GET
    public List<Experiment> listExperiments() {
        return Experiment.listAll();
    }

    @POST
    @Transactional
    public Response addExperiment(Experiment experiment) {
        Experiment.persist(experiment);
        return Response.status(Response.Status.CREATED).entity(experiment).build();
    }
}
