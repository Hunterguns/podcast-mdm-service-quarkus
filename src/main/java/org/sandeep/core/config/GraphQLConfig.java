//package org.sandeep.core.config;
//
//import graphql.schema.GraphQLScalarType;
//import graphql.schema.idl.RuntimeWiring;
//import io.micrometer.observation.annotation.Observed;
//import io.quarkus.runtime.StartupEvent;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.event.Observes;
//import jakarta.inject.Inject;
//import org.eclipse.microprofile.graphql.GraphQLApi;
//
//@GraphQLApi
//@ApplicationScoped
//public class GraphQLConfig {
//    @Inject
//    RuntimeWiring.Builder runtimeWiringBuilder;
//
//    void configureGraphQL(@Observes StartupEvent startupEvent){
//        GraphQLScalarType uploadScalar = GraphQLScalarType.newScalar()
//                .name("Upload")
//                .description("A File part in multipart request")
//                .coercing(new UploadCoercing())
//                .build();
//
//        runtimeWiringBuilder.scalar(uploadScalar);
//    }
//}
//
//
