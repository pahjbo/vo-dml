/*
 * Created on 3 May 2023 
 * Copyright 2023 Paul Harrison (paul.harrison@manchester.ac.uk)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License in file LICENSE
 */ 

package org.ivoa.vodml.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.ivoa.vodml.VodmlModel;
import org.junit.jupiter.api.Test;

/**
 * An abstract base Test that does some tests .
 * @author Paul Harrison (paul.harrison@manchester.ac.uk) 
 * @since 3 May 2023
 */
public abstract  class AutoRoundTripTest <T extends VodmlModel<T>> extends BaseValidationTest {
    
    
    public abstract  T createModel();
    
    public abstract void testModel(T m);
    
    
    @Test
    void testXmlRoundTrip() throws JAXBException, TransformerConfigurationException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, IOException {
        
        T model = createModel();
        RoundTripResult<T> result = roundtripXML(model.management());
        assertTrue(result.isValid, "reading XML back had errors");
        assertNotNull(result.retval,"returned object from XML serialization null");
        testModel(model);
    }

    @Test
    void testJSONRoundTrip() throws JAXBException, TransformerConfigurationException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, IOException {
        
        T model = createModel();
        RoundTripResult<T> result = roundTripJSON(model.management());
        assertTrue(result.isValid, "reading JSON back had errors");
        assertNotNull(result.retval,"returned object from JSON serialization null");
        testModel(model);
    }


}


