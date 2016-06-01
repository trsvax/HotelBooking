package com.trsvax.hotelbooking.services.documentation.hotelbooking;

import org.apache.tapestry5.ioc.def.ServiceDef;
import org.slf4j.Logger;

import com.trsvax.tapestry.documentation.services.Documentation;
import com.trsvax.tapestry.documentation.services.DocumentationStrategy;

public class ServiceDefDocumentation implements DocumentationStrategy<ServiceDef> {
	
	private final Logger logger;
	
	public ServiceDefDocumentation(Logger logger) {
		this.logger = logger;
	}

	@Override
	public Documentation getDocumentation(ServiceDef serviceDef) {
		logger.info("hotel {}",serviceDef.getServiceId());
		if ( "DocumentationChain".equals(serviceDef.getServiceId()) ) {
			return new Documentation() {
				
				@Override
				public String getJavaDoc() {
					return "HotelURL";
				}
			};
		}
		return null;
	}

	
}
