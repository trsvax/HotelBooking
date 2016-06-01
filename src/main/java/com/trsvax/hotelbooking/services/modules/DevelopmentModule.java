package com.trsvax.hotelbooking.services.modules;


import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.ImportModule;

import com.trsvax.hotelbooking.services.documentation.hotelbooking.HotelBookingDocumentationModule;
import com.trsvax.jacquard.JacquardSymbols;
import com.trsvax.jacquard.services.JacquardModule;
import com.trsvax.tapestry.documentation.services.modules.TapestryDocumentationModule;

@ImportModule({TapestryDocumentationModule.class,HotelBookingDocumentationModule.class,JacquardModule.class})
public class DevelopmentModule {
	
    public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration) {
        configuration.add(SymbolConstants.PRODUCTION_MODE, false);
        configuration.override(JacquardSymbols.JOBPACKAGE, "com.trsvax.hotelbooking.pages.jobs");
        configuration.override(JacquardSymbols.JOBURL, "http://localhost:8080/hotel/jobs/");
    }
}
