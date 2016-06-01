package com.trsvax.hotelbooking.services.documentation.hotelbooking;

import java.util.Map;

import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.InjectService;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.ServiceId;
import org.apache.tapestry5.ioc.def.ServiceDef;
import org.apache.tapestry5.ioc.services.StrategyBuilder;

import com.trsvax.tapestry.documentation.services.Documentation;
import com.trsvax.tapestry.documentation.services.DocumentationChain;
import com.trsvax.tapestry.documentation.services.DocumentationStrategy;
import com.trsvax.tapestry.documentation.services.ObjectDocumentation;

public class HotelBookingDocumentationModule {

	private final static String servivePrefix = "HotelBookingDocumentationModule";
	
    public static void bind(ServiceBinder binder) {
        binder.bind(DocumentationStrategy.class,ServiceDefDocumentation.class).withId(servivePrefix + "ServiceDef");
    }
    
    @Contribute(DocumentationChain.class)
    public static void configureDocumentationChain(OrderedConfiguration<DocumentationChain<?>> configuration,
    		@InjectService(servivePrefix + "TD") final DocumentationStrategy<Object> documentationStrategy) {
    	configuration.add("HotelBookingDocumentation", new DocumentationChain<Object>() {

			@Override
			public Documentation getDocumentation(Object object) {
				return documentationStrategy.getDocumentation(object);
			}
		});
    }
	
    @SuppressWarnings("rawtypes")

    @Contribute(DocumentationStrategy.class)
    @Local
    public static void configureDocumentationStrategy(
    		MappedConfiguration<Class, DocumentationStrategy> configuration,
    		@InjectService(servivePrefix + "ServiceDef") DocumentationStrategy serviceDef)  {
    	configuration.add(ServiceDef.class, serviceDef);
    	configuration.addInstance(Object.class, ObjectDocumentation.class);

    }

    @SuppressWarnings("rawtypes")
    @ServiceId(servivePrefix + "TD")
    public static DocumentationStrategy<?> build(@Local Map<Class, DocumentationStrategy> configuration,
    		  @InjectService("StrategyBuilder") StrategyBuilder builder)
    		{
    		 
    		   return builder.build(DocumentationStrategy.class,configuration);
    		}
}
