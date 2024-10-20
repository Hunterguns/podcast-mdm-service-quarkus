package org.sandeep.core.config;

import graphql.schema.Coercing;

import java.io.File;

public class UploadCoercing implements Coercing<File, Void> {
    @Override
    public File parseValue(Object input){
        return (File) input;
    }

    @Override
    public File parseLiteral(Object input){
        throw new UnsupportedOperationException("Upload scalar cannot be used as input literal");
    }

    @Override
    public Void serialize(Object input){
        throw new UnsupportedOperationException("Upload scalar cannot be serialized");

    }
}
